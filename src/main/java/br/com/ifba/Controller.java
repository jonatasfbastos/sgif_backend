package br.com.ifba;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.ifba.empenho.model.Empenho;
import br.com.ifba.empenho.service.IServiceEmpenho;
import br.com.ifba.fornecedor.model.Fornecedor;
import br.com.ifba.fornecedor.service.IServiceFornecedor;
import br.com.ifba.infrastructure.support.StringUtil;
import br.com.ifba.item.model.Item;
import br.com.ifba.item.service.IServiceItem;
import br.com.ifba.notification.model.Notification;
import br.com.ifba.notification.service.IServiceNotification;
import br.com.ifba.pedido.model.Pedido;
import br.com.ifba.pedido.service.IServicePedido;
import br.com.ifba.perfilusuarioo.model.PerfilUsuario;
import br.com.ifba.perfilusuarioo.service.IServicePerfilUsuario;
import br.com.ifba.pessoa.model.Pessoa;
import br.com.ifba.pessoa.service.IServicePessoa;
import br.com.ifba.requisicao.model.Requisicao;
import br.com.ifba.requisicao.service.IServiceRequisicao;
import br.com.ifba.setor.model.Setor;
import br.com.ifba.setor.service.IServiceSetor;
import br.com.ifba.tipodeitem.model.TipoDeItem;
import br.com.ifba.tipodeitem.service.IServiceTipoItem;
import br.com.ifba.usuario.model.Usuario;
import br.com.ifba.usuario.service.IServiceUsuario;

/*=========================ATENÇÃO=========================
 * As classes a seguir estão organizadas em ordem alfabética assim como seus respectivos métodos. Caso for fazer alguma alteração, continue com a organização!
 *  
*/
@RestController
@RequestMapping(path = "/api/v1/app")
public class Controller {
    Gson gson = new Gson();

    @RequestMapping(path = "/hello")
    public String helloWorld(@RequestParam String name) {
        String usuario = "{senha:'" + name + "'}";
        Usuario user = (Usuario) gson.fromJson(usuario, Usuario.class);
        return "Hello " + user.getSenha() + "!";
    }

    // ------------------------------------------------------------------------------
    // ------------------------------- Empenho ----------------------------------
    // ------------------------------------------------------------------------------

    @Autowired
    private IServiceEmpenho serviceEmpenho;

    @RequestMapping(path = "deletarEmpenho", method = RequestMethod.GET)
    public boolean deletarEmpenho(Long id) {
        Empenho empenho = new Empenho();
        empenho.setId(id);
        serviceEmpenho.deleteEmpenho(empenho);
        return true;
    }

    @RequestMapping(path = "/empenho")
    public List<Empenho> listarEmpenho() {
        return (List<Empenho>) serviceEmpenho.getAllEmpenho();
    }

    @RequestMapping(path = "/empenhosValidos")
    public List<Empenho> listarEmpenhosValidos() {
        return (List<Empenho>) serviceEmpenho.validadeAfter(new java.util.Date());
    }

    @RequestMapping(path = "/salvarEmpenho", method = RequestMethod.POST)
    public Empenho salvarEmpenho(@RequestBody String empenho1) {
        Empenho empenho = (Empenho) gson.fromJson(empenho1, Empenho.class);
        return serviceEmpenho.saveEmpenho(empenho);
    }

    // Rodando de 5 em 5 minutos
    @Scheduled(fixedDelay = 60000)
    public void sendNotificationsWhenDue() throws InterruptedException {
        List<Empenho> empenhos = serviceEmpenho
                .validadeBefore(new java.util.Date());

        if (empenhos == null)
            return;

        // System.out.println("Send notification Empenho's due");
        for (Empenho empenho : empenhos) {
            Notification notification = serviceNotification.findByWhatIdAndWhatObjectName(empenho.getId(),
                    empenho.getClass().getSimpleName());

            if (notification != null)
                continue;

            String title = "Um empenho está vencido";
            String body = "O empenho com nota " + empenho.getNota() + " e valor R$ "
                    + String.valueOf(empenho.getValor()).replace('.', ',')
                    + " está vencido, acesse e siga os passos necessários.";

            notification = Notification.createNotification(title, body, empenho);
            serviceNotification.saveNotification(notification);
        }
    }

    // ---------------------------------------------------
    // ------------- Fornecedor -----------------------------
    // ---------------------------------------------------

    @Autowired
    private IServiceFornecedor serviceFornecedor;

    @RequestMapping(path = "deletarFornecedor", method = RequestMethod.GET)
    public boolean deletarFornecedor(Long id) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(id);
        serviceFornecedor.deleteFornecedor(fornecedor);
        return true;
    }

    @RequestMapping(path = "/fornecedor")
    public List<Fornecedor> salvarFornecedor() {
        return (List<Fornecedor>) serviceFornecedor.getAllFornecedor();
    }

    @RequestMapping(path = "/salvarFornecedor", method = RequestMethod.POST)
    public Fornecedor salvarFornecedor(@RequestBody String fornecedor) {
        Fornecedor forn = (Fornecedor) gson.fromJson(fornecedor, Fornecedor.class);
        return serviceFornecedor.saveFornecedor(forn);
    }
    // ---------------------------------------------------
    // ------------- Pessoa -----------------------------
    // ---------------------------------------------------

    @Autowired
    private IServicePessoa servicePessoa;

    @RequestMapping(path = "deletarPessoa", method = RequestMethod.GET)
    public boolean deletarPessoa(Long id) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        servicePessoa.delete(pessoa);
        return true;
    }

    @RequestMapping(path = "/pessoas")
    public List<Pessoa> getPessoas() {
        return (List<Pessoa>) servicePessoa.getAllPessoas();
    }

    @RequestMapping(path = "/salvarPessoa", method = RequestMethod.POST)
    public Pessoa salvarPessoa(@RequestBody String pessoa) {
        Pessoa pess = (Pessoa) gson.fromJson(pessoa, Pessoa.class);
        return servicePessoa.savePessoa(pess);
    }

    // ---------------------------------------------------
    // ------------- Item -----------------------------
    // ---------------------------------------------------

    @Autowired
    private IServiceItem serviceItem;

    @RequestMapping(path = "/atualizarItem", method = RequestMethod.POST)
    public Item atualizarItem(@RequestBody String item) {
        Item itemm = (Item) gson.fromJson(item, Item.class);
        if (itemm.getId() == null)
            return null;
        return serviceItem.saveItem(itemm);
    }

    @RequestMapping(path = "deletarItem", method = RequestMethod.GET)
    public boolean deletarItem(Long id) {
        Item item = new Item();
        item.setId(id);
        serviceItem.deleteItem(item);
        return true;
    }

    @RequestMapping(path = "/Item")
    public List<Item> salvarItem() {
        return (List<Item>) serviceItem.getAllItens();
    }

    @RequestMapping(path = "/salvarItem", method = RequestMethod.POST)
    public Item salvarItem(@RequestBody String itemm) {
        Item item = (Item) gson.fromJson(itemm, Item.class);
        System.out.println(item.toString());
        return serviceItem.saveItem(item);
    }

    // ---------------------------------------------------
    // ------------- NOTIFICAÇÃO -------------------------
    // ---------------------------------------------------

    @Autowired
    private IServiceNotification serviceNotification;

    @RequestMapping(path = "notifications")
    public List<Notification> getNotifications() {
        return serviceNotification.getAllNotification();
    }

    @RequestMapping(path = "notificationsUnread")
    public List<Notification> getNotificationsUnread() {
        return serviceNotification.findByReaded(false);
    }

    @RequestMapping(path = "setReadNotification")
    public Notification setReadNotification(Long id) {
        Notification not = serviceNotification.findById(id);
        if (not == null)
            return null;
        not.setReaded(true);
        return serviceNotification.saveNotification(not);
    }

    @RequestMapping(path = "saveNotification")
    public Notification saveNotification() {
        Notification not = new Notification();
        not.setTitle("Notificaçõ teste");
        not.setBody("Olá, essa é uma notificação teste");
        return serviceNotification.saveNotification(not);
    }

    // ------------------------------------------------------------------------------
    // ------------------------------- Pedido ----------------------------------
    // ------------------------------------------------------------------------------

    @Autowired
    private IServicePedido servicePedido;

    @RequestMapping(path = "deletarPedido", method = RequestMethod.GET)
    public boolean deletarPedido(Long id) {
        Pedido pedido = new Pedido();
        pedido.setId(id);
        servicePedido.deletePedido(pedido);
        return true;
    }

    @RequestMapping(path = "/pedido")
    public List<Pedido> listarPedido() {
        return (List<Pedido>) servicePedido.getAllPedido();
    }

    @RequestMapping(path = "/salvarPedido", method = RequestMethod.POST)
    public Pedido salvarPedido(@RequestBody String empenho1) {
        Pedido pedido = (Pedido) gson.fromJson(empenho1, Pedido.class);
        return servicePedido.savePedido(pedido);
    }

    // ---------------------------------------------------
    // ------------- Requisição -----------------------------
    // ---------------------------------------------------

    @Autowired
    private IServiceRequisicao serviceRequisicao;

    @RequestMapping(path = "/deletarRequisicao", method = RequestMethod.GET)
    public boolean deletarRequisicao(Long id) {
        Requisicao requisicaoo = new Requisicao();
        requisicaoo.setId(id);
        serviceRequisicao.deleteRequisicao(requisicaoo);
        return true;
    }

    @RequestMapping(path = "/requisicao")
    public List<Requisicao> salvarRequisicao() {
        return (List<Requisicao>) serviceRequisicao.getAllRequisicao();
    }

    @RequestMapping(path = "/salvarRequisicao", method = RequestMethod.POST)
    public Requisicao salvarRequisicao(@RequestBody String requisicoes) {
        Requisicao requisicaoo = (Requisicao) gson.fromJson(requisicoes, Requisicao.class);
        return serviceRequisicao.saveRequisicao(requisicaoo);
    }

    // ---------------------------------------------------
    // ------------- Setor -----------------------------
    // ---------------------------------------------------

    @Autowired
    private IServiceSetor serviceSetor;

    @RequestMapping(path = "deletarSetor", method = RequestMethod.GET)
    public boolean deletarSetor(Long id) {
        Setor setor = new Setor();
        setor.setId(id);
        serviceSetor.deleteSetor(setor);
        return true;
    }

    @RequestMapping(path = "/setor")
    public List<Setor> salvarSetor() {
        return (List<Setor>) serviceSetor.getAllSetor();
    }

    @RequestMapping(path = "/salvarSetor", method = RequestMethod.POST)
    public Setor salvarSetor(@RequestBody String ssetor) {
        Setor setor = (Setor) gson.fromJson(ssetor, Setor.class);
        return serviceSetor.saveSetor(setor);
    }

    @RequestMapping(path = "/setorItem/{id}")
    public List<Item> listarItensPorSetor(@PathVariable Long id) {
        return (List<Item>) serviceSetor.getSetorItens(id, serviceRequisicao.getAllRequisicao());
    }

    // ---------------------------------------------------
 
    @Autowired
    private IServiceTipoItem serviceTipoItem;

    @RequestMapping(path = "/atualizarTipoItem", method = RequestMethod.POST)
    public TipoDeItem atualizarTipoDeItem(@RequestBody String tipodeitem) {
        TipoDeItem tipo = (TipoDeItem) gson.fromJson(tipodeitem, TipoDeItem.class);
        if (tipo.getId() == null)
            return null;
        return serviceTipoItem.savetipoDeItem(tipo);
    }

    @RequestMapping(path = "/deletarTipoItem", method = RequestMethod.GET)
    public boolean deletarTipoDeItem(Long id) {
        TipoDeItem tipo = new TipoDeItem();
        tipo.setId(id);
        serviceTipoItem.deletetipoDeItem(tipo);
        return true;
    }

    @RequestMapping(path = "/tipoDeItem")
    public List<TipoDeItem> gettTipoDeItem() {
        return serviceTipoItem.getAlltipoDeItem();
    }

    @RequestMapping(path = "/salvarTipoItem", method = RequestMethod.POST)
    public TipoDeItem salvarTipoDeItem(@RequestBody String tipodeitem) {
        TipoDeItem tipo = (TipoDeItem) gson.fromJson(tipodeitem, TipoDeItem.class);
        return serviceTipoItem.savetipoDeItem(tipo);
    }

    // ---------------------------------------------------
    // ------------- PERFIL USUARIO -----------------------------
    // ---------------------------------------------------

    @Autowired
    private IServicePerfilUsuario servicePerfilUsuario;

    @RequestMapping(path = "deletarPerfilDeUsuario", method = RequestMethod.GET)
    public boolean deletarPerfilUsuario(Long id) {
        PerfilUsuario pusuario = new PerfilUsuario();
        pusuario.setId(id);
        servicePerfilUsuario.deletePerfilUsuario(pusuario);
        return true;
    }

    @RequestMapping(path = "/salvarPerfilUsuario", method = RequestMethod.POST)
    public PerfilUsuario salvarPerfilUsuario(@RequestBody String perfilusuario) {
        PerfilUsuario pusuario = (PerfilUsuario) gson.fromJson(perfilusuario, PerfilUsuario.class);
        return servicePerfilUsuario.savePerfilUsuario(pusuario);
    }

    @RequestMapping(path = "/perfilusuario")
    public List<PerfilUsuario> salvarPerfilUsuario() {
        return (List<PerfilUsuario>) servicePerfilUsuario.getAllPerfilUsuario();
    }

    // ---------------------------------------------------
    // ------------- USUARIO -----------------------------
    // ---------------------------------------------------
    @Autowired
    private IServiceUsuario serviceUsuario;

    @RequestMapping(path = "/atualizarUsuario", method = RequestMethod.POST)
    public Usuario atualizarUsuario(@RequestBody String usuario) {
        Usuario user = (Usuario) gson.fromJson(usuario, Usuario.class);
        if (user.getId() == null)
            return null;
        return serviceUsuario.saveUsuario(user);
    }

    @RequestMapping(path = "/deletarUsuario", method = RequestMethod.GET)
    public boolean deletarUsuario(Long id) {
        Usuario user = new Usuario();
        user.setId(id);
        serviceUsuario.deleteUsuario(user);
        return true;
    }

    @RequestMapping(path = "/login")
    public Usuario login(String login, String senha) {
        Usuario user = serviceUsuario.findByLoginAndSenha(login, senha);

        if (user == null) {
            user = serviceUsuario.findByLoginAndSenha(login, StringUtil.toMD5(senha));
        }

        return user;
    }

    @RequestMapping(path = "/salvarUsuario", method = RequestMethod.POST)
    public Usuario salvarUsuario(@RequestBody String usuario) {
        Usuario user = (Usuario) gson.fromJson(usuario, Usuario.class);
        return serviceUsuario.saveUsuario(user);
    }

    @RequestMapping(path = "/usuarios")
    public List<Usuario> getUsuarios() {
        return serviceUsuario.getAllUsuarios();
    }

    @RequestMapping(path = "/usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        System.out.println("Id " + id);
        return (Usuario) this.serviceUsuario.findById(id);
    }
}