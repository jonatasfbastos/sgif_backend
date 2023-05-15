package br.com.ifba;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import br.com.ifba.funcaotecnicoadministrativo.model.FuncaoTecnicoAdministrativo;
import br.com.ifba.funcaotecnicoadministrativo.service.IServiceFuncaoTecnicoAdministrativo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;


import br.com.ifba.avaliacao.model.Avaliacao;
import br.com.ifba.avaliacao.service.IServiceAvaliacao;
import br.com.ifba.aluno.model.Aluno;
import br.com.ifba.aluno.service.IServiceAluno;
import br.com.ifba.disciplina.model.Disciplina;
import br.com.ifba.disciplina.service.IServiceDisciplina;
import br.com.ifba.empenho.model.Empenho;
import br.com.ifba.empenho.service.IServiceEmpenho;
import br.com.ifba.etapacurso.model.EtapaCurso;
import br.com.ifba.etapacurso.service.IServiceEtapaCurso;
import br.com.ifba.formulario.model.Formulario;
import br.com.ifba.formulario.service.IServiceFormulario;
import br.com.ifba.fornecedor.model.Fornecedor;
import br.com.ifba.fornecedor.service.IServiceFornecedor;
import br.com.ifba.infrastructure.support.StringUtil;
import br.com.ifba.item.model.Item;
import br.com.ifba.item.service.IServiceItem;
import br.com.ifba.matrizcurricular.model.MatrizCurricular;
import br.com.ifba.matrizcurricular.service.IServiceMatrizCurricular;
import br.com.ifba.modalidade.model.Modalidade;
import br.com.ifba.modalidade.service.IServiceModalidade;
import br.com.ifba.notification.model.Notification;
import br.com.ifba.notification.service.IServiceNotification;
import br.com.ifba.pedido.model.Pedido;
import br.com.ifba.pedido.service.IServicePedido;
import br.com.ifba.perfilusuario.model.PerfilUsuario;
import br.com.ifba.perfilusuario.service.IServicePerfilUsuario;
import br.com.ifba.pessoa.model.Pessoa;
import br.com.ifba.pessoa.service.IServicePessoa;
import br.com.ifba.relatoriomensal.model.RelatorioMensal;
import br.com.ifba.relatoriomensal.service.IServiceRelatorioMensal;
import br.com.ifba.requisicao.model.Requisicao;
import br.com.ifba.requisicao.service.IServiceRequisicao;
import br.com.ifba.setor.model.Setor;
import br.com.ifba.setor.service.IServiceSetor;
import br.com.ifba.tecnicoadministrativo.model.TecnicoAdministrativo;
import br.com.ifba.tecnicoadministrativo.service.IServiceTecnicoAdministrativo;
import br.com.ifba.tecnicoadministrativo.service.ServiceTecnicoAdministrativo;
import br.com.ifba.terceirizado.model.Terceirizado;
import br.com.ifba.terceirizado.service.IServiceTerceirizado;
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
    // ------------------------------- Avaliação ------------------------------------
    // ------------------------------------------------------------------------------

    @Autowired
    private IServiceAvaliacao serviceAvaliacao;

    @RequestMapping(path = "deletarAvaliacao", method = RequestMethod.GET)
    public boolean deletarAvaliacao(Long id) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setId(id);
        serviceAvaliacao.deleteAvaliacao(avaliacao);
        return true;
    }

    @RequestMapping(path = "/avaliacao")
    public List<Avaliacao> listarAvaliacao() {
        return (List<Avaliacao>) serviceAvaliacao.getAllAvaliacao();
    }

    @RequestMapping(path = "/salvarAvaliacao", method = RequestMethod.POST)
    public Avaliacao salvarAvaliacao(@RequestBody String avaliacao1) {
        Avaliacao avaliacao = (Avaliacao) gson.fromJson(avaliacao1, Avaliacao.class);
        return serviceAvaliacao.saveAvaliacao(avaliacao);
    }


    // ------------------------------------------------------------------------------
    // --------------------------------- Aluno --------------------------------------
    // ------------------------------------------------------------------------------
    
    @Autowired
    private IServiceAluno serviceAluno;

    @RequestMapping(path = "/alunos")
    public List<Aluno> listarAluno() {
        return (List<Aluno>) serviceAluno.getAllaluno();
    }

    @RequestMapping(path = "/salvarAluno", method = RequestMethod.POST)
    public Aluno salvarAluno(@RequestBody String aluno1) {
        Aluno aluno = (Aluno) gson.fromJson(aluno1, Aluno.class);
        return serviceAluno.saveAluno(aluno);
    }

    @RequestMapping(path = "deletarAluno", method = RequestMethod.GET)
    public boolean deletarAluno(Long id) {
        Aluno aluno = new Aluno();
        aluno.setId(id);
        serviceAluno.deleteAluno(aluno);
        return true;
    }
    
    // ------------------------------------------------------------------------------
    // ------------------------------- Disciplina ----------------------------------
    // ------------------------------------------------------------------------------

    @Autowired
    private IServiceDisciplina serviceDisciplina;

    @RequestMapping(path = "/disciplina")
    public List<Disciplina> listarDisciplina() {
        return (List<Disciplina>) serviceDisciplina.getAllDisciplina();
    }

    @RequestMapping(path = "/salvarDisciplina", method = RequestMethod.POST)
    public Disciplina salvarDisciplina(@RequestBody String disciplina1) {
        Disciplina disciplina = (Disciplina) gson.fromJson(disciplina1, Disciplina.class);
        return serviceDisciplina.saveDisciplina(disciplina);
    }

    @RequestMapping(path = "deletarDisciplina", method = RequestMethod.DELETE)
    public boolean deletarDisciplina(Long id) {
        Disciplina disciplina = new Disciplina();
        disciplina.setId(id);
        serviceDisciplina.deleteDisciplina(disciplina);
        return true;
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

    @RequestMapping(path = "/salvarEmpenho", method = RequestMethod.POST)
    public Empenho salvarEmpenho(@RequestBody String empenho1) {
        Empenho empenho = (Empenho) gson.fromJson(empenho1, Empenho.class);
        return serviceEmpenho.saveEmpenho(empenho);
    }

    

    // @Scheduled(fixedDelay = 10000)
    // private void alertaMsg(Date date){
    //     timer = new Timer();

    //     timer.schedule(new TimerTask(){
            
    //         @Override
    //         public void run(){
    //             try {
    //                 sendNotificationsWhenDue();
    //             } catch (InterruptedException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     }, date);
    // }

    
    public Date getDataAjuste(Date data, int num){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.DATE, -num);
   
        return calendar.getTime();
   }

    // Rodando de 5 em 5 minutos
    @Scheduled(fixedDelay = 5000)
    public void sendNotificationsWhenDue() throws InterruptedException {
        List<Item> item = serviceItem.getAllItens();
        
        for(int i = 0; i < item.size(); i++){
        
        List<Item> itens = serviceItem.validadeBefore(getDataAjuste(item.get(i).getValidade(), item.get(i).getAlerta()));

        // System.out.println("Send notification Empenho's due");
        for (Item empenho : itens) {
            Notification notification = serviceNotification.findByWhatIdAndWhatObjectName(empenho.getId(),
                    empenho.getClass().getSimpleName());

            if (notification != null)
                continue;

            String title = "Alerta de vencimento de item";
            String body = "O item: " + empenho.getNome() + ", de valor R$ "
                    + String.valueOf(empenho.getValorItem()).replace('.', ',')
                    + " vai vencer dia " + empenho.getValidade();

            notification = Notification.createNotification(title, body, empenho);
            serviceNotification.saveNotification(notification);
        }
    }
}

    //--------------------------------------------------------
    //--------------- etapa curso ------------------------------
    //-------------------------------------------------------
    
    @Autowired
    private IServiceEtapaCurso serviceEtapaCurso;


    @RequestMapping(path = "deletarEtapaCurso", method = RequestMethod.GET)
    public boolean deletarEtapaCurso(Long id) {
        EtapaCurso etapaCurso = new EtapaCurso();
        etapaCurso.setId(id);
        serviceEtapaCurso.deleteEtapaCurso(etapaCurso);
        return true;
    }

    @RequestMapping(path = "/etapaCurso")
    public List<EtapaCurso> salvarEtapaCurso() {
        return (List<EtapaCurso>) serviceEtapaCurso.getAllEtapaCurso();
    }

    @RequestMapping(path = "/salvarEtapaCurso", method = RequestMethod.POST)
    public EtapaCurso salvarEtapaCurso(@RequestBody String etapa) {
        EtapaCurso etapaCurso = (EtapaCurso) gson.fromJson(etapa, EtapaCurso.class);
        System.out.println(etapaCurso.toString());
        return serviceEtapaCurso.saveEtapaCurso(etapaCurso);
    }

    //-------------------------------------
    //---------- Formulário ---------------
    //-------------------------------------
    @Autowired
    private IServiceFormulario serviceFormulario;

    @RequestMapping(path = "/atualizarFormulario", method = RequestMethod.POST)
    public Formulario atualizarFormulario(@RequestBody String formulario) {
        Formulario frm = (Formulario) gson.fromJson(formulario, Formulario.class);
        if (frm.getId() == null)
            return null;
        return serviceFormulario.saveFormulario(frm);
    }

    @RequestMapping(path = "/deletarFormulario", method = RequestMethod.GET)
    public boolean deletarFormulario(Long id) {
        Formulario frm = new Formulario();
        frm.setId(id);
        serviceFormulario.deleteFormulario(frm);
        return true;
    }

    @RequestMapping(path = "/salvarFormulario", method = RequestMethod.POST)
    public Formulario salvarFormulario(@RequestBody String formulario) {
        Formulario frm = (Formulario) gson.fromJson(formulario, Formulario.class);
        return serviceFormulario.saveFormulario(frm);
    }

    @RequestMapping(path = "/formularios")
    public List<Formulario> getFormularios() {
        return serviceFormulario.getAllFormulario();
    }

    @RequestMapping(path = "/formulario/{id}")
    public Formulario getFormulario(@PathVariable Long id) {
        System.out.println("Id " + id);
        return (Formulario) this.serviceFormulario.findById(id);
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
    // ------------- Funcao Tecnico Admistrativo ---------
    // ---------------------------------------------------
    @Autowired
    private IServiceFuncaoTecnicoAdministrativo serviceFuncaoTecnicoAdm;

    @PostMapping("/salvarFuncaoTecnicoAdm")
    public ResponseEntity<Object> salvarFuncaoTecnicoAdm
            (@RequestBody FuncaoTecnicoAdministrativo funcaoTecnicoAdm) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(serviceFuncaoTecnicoAdm.saveFuncaoTecnicoAdm(funcaoTecnicoAdm));
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(err.getMessage());
        }
    }

    @GetMapping("/listarFuncoesTecnicoAdm")
    public ResponseEntity<Object> listarFuncoesTecnicoAdm() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(serviceFuncaoTecnicoAdm.getAllFuncoesTecnicoAdm());
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(err.getMessage());
        }
    }

    @PutMapping("/atualizarFuncaoTecnicoAdm")
    public ResponseEntity<Object> atualizarFuncaoTecnicoAdm
            (@RequestBody FuncaoTecnicoAdministrativo funcaoTecnicoAdm) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(serviceFuncaoTecnicoAdm.saveFuncaoTecnicoAdm(funcaoTecnicoAdm));
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(err.getMessage());
        }
    }

    @DeleteMapping("/deletarFuncaoTecnicoAdm/{id}")
    public ResponseEntity<Object> deletarFuncaoTecnicoAdm
            (@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(serviceFuncaoTecnicoAdm.deleteFuncaoTecnicoAdm(id));
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(err.getMessage());
        }
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
    // ------------- MATRIZ CURRICULAR -------------------
    // ---------------------------------------------------
    
    @Autowired
    private IServiceMatrizCurricular serviceMatriz;

    @RequestMapping(path = "/atualizarMatriz", method = RequestMethod.POST)
    public MatrizCurricular atualizarMatriz(@RequestBody String matriz) {
        MatrizCurricular mc = (MatrizCurricular) gson.fromJson(matriz, MatrizCurricular.class);
        if (mc.getId() == null)
            return null;
        return serviceMatriz.saveMatrizCurricular(mc);
    }

    @RequestMapping(path = "/deletarMatriz", method = RequestMethod.GET)
    public boolean deletarMatriz(Long id) {
        MatrizCurricular mc = new MatrizCurricular();
        mc.setId(id);
        serviceMatriz.deleteMatrizCurricular(mc);
        return true;
    }

    @RequestMapping(path = "/salvarMatriz", method = RequestMethod.POST)
    public MatrizCurricular salvarMatriz(@RequestBody String matriz) {
        MatrizCurricular mc = (MatrizCurricular) gson.fromJson(matriz, MatrizCurricular.class);
        return serviceMatriz.saveMatrizCurricular(mc);
    }

    @RequestMapping(path = "/matrizes")
    public List<MatrizCurricular> getMatrizes() {
        return serviceMatriz.getAllMatrizCurricular();
    }

    @RequestMapping(path = "/matriz/{id}")
    public MatrizCurricular getMatriz(@PathVariable Long id) {
        System.out.println("Id " + id);
        return (MatrizCurricular) this.serviceMatriz.findById(id);
    }

    // ---------------------------------------------------
    // ----------------- Modalidade ----------------------
    // ---------------------------------------------------
    
    @Autowired
    private IServiceModalidade serviceModalidade;

    @RequestMapping(path = "/atualizarModalidade", method = RequestMethod.POST)
    public Modalidade atualizarModalidade(@RequestBody String modalidade) {
        Modalidade mod = (Modalidade) gson.fromJson(modalidade, Modalidade.class);
        if (mod.getId() == null)
            return null;
        return serviceModalidade.saveModalidade(mod);
    }

    @RequestMapping(path = "/deletarModalidade", method = RequestMethod.GET)
    public boolean deletarModalidade(Long id) {
        Modalidade mod = new Modalidade();
        mod.setId(id);
        serviceModalidade.deleteModalidade(mod);
        return true;
    }

    @RequestMapping(path = "/salvarModalidade", method = RequestMethod.POST)
    public Modalidade salvarModalidade(@RequestBody String modalidade) {
        Modalidade mod = (Modalidade) gson.fromJson(modalidade, Modalidade.class);
        return serviceModalidade.saveModalidade(mod);
    }

    @RequestMapping(path = "/modalidades")
    public List<Modalidade> getModalidades() {
        return serviceModalidade.getAllModalidade();
    }

    @RequestMapping(path = "/modalidade/{id}")
    public Modalidade getModalidade(@PathVariable Long id) {
        System.out.println("Id " + id);
        return (Modalidade) this.serviceModalidade.findById(id);
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
    // ------------- Relatório Mensal -----------------------------
    // ---------------------------------------------------

    @Autowired
    private IServiceRelatorioMensal serviceRelatorio;

    @RequestMapping(path = "/deletarRelatorio", method = RequestMethod.GET)
    public boolean deletarRelatorio(Long id) {
        RelatorioMensal relatorio = new RelatorioMensal();
        relatorio.setId(id);
        serviceRelatorio.delete(relatorio);
        return true;
    }

    @RequestMapping(path = "/relatorio")
    public List<RelatorioMensal> salvarRelatorio() {
        return (List<RelatorioMensal>) serviceRelatorio.getAllRelatorioMensal();
    }

    @RequestMapping(path = "/salvarRelatorio", method = RequestMethod.POST)
    public RelatorioMensal salvarRelatorioMensal(@RequestBody String relatorios) {
        RelatorioMensal relatorio = (RelatorioMensal) gson.fromJson(relatorios, RelatorioMensal.class);
        return serviceRelatorio.saveRelatorioMensal(relatorio);
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
    // ------------- TECNICO ADMINISTRATIVO -----------------------------
    // ---------------------------------------------------
    
    @Autowired
    private IServiceTecnicoAdministrativo serviceTecnicoAdministrativo;
    
    @PostMapping("/salvarTecnicoAdministrativo")
    public ResponseEntity<Object> salvarTecnicoAdministrativo
            (@RequestBody TecnicoAdministrativo tecnicoAdministrativo) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(serviceTecnicoAdministrativo.saveTecnicoAdministrativo(tecnicoAdministrativo));
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(err.getMessage());
        }
    }

    @GetMapping("/listarTecnicoAdministrativo")
    public ResponseEntity<Object> listarTecnicoAdministrativo() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(serviceTecnicoAdministrativo.getAllTecnicoAdministrativo());
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(err.getMessage());
        }
    }

    @PutMapping("/atualizarTecnicoAdministrativo")
    public ResponseEntity<Object> atualizarTecnicoAdministrativo
            (@RequestBody TecnicoAdministrativo TecnicoAdministrativo) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(serviceTecnicoAdministrativo.saveTecnicoAdministrativo(TecnicoAdministrativo));
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(err.getMessage());
        }
    }

    @DeleteMapping("/deletarTecnicoAdministrativo/{id}")
    public ResponseEntity<Object> deletarTecnicoAdministrativo
            (@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(serviceTecnicoAdministrativo.deleteTecnicoAdministrativo(id));
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(err.getMessage());
        }
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
    
    // ---------------------------------------------------
    // ------------- Terceirizado -----------------------------
    // ---------------------------------------------------

    @Autowired
    private IServiceTerceirizado serviceTerceirizado;

    @RequestMapping(path = "deletarTerceirizado", method = RequestMethod.GET)
    public boolean deletarTerceirizado(Long id) {
        Terceirizado terceirizado = new Terceirizado();
        terceirizado.setId(id);
        servicePessoa.delete(terceirizado);
        return true;
    }

    @RequestMapping(path = "/terceirizado")
    public List<Terceirizado> getTerceirizado() {
        return (List<Terceirizado>) serviceTerceirizado.getAllterceirizado();
    }

    @RequestMapping(path = "/salvarTerceirizado", method = RequestMethod.POST)
    public Terceirizado salvarTerceirizado(@RequestBody String terceirizado) {
        Terceirizado terc = (Terceirizado) gson.fromJson(terceirizado, Terceirizado.class);
        return serviceTerceirizado.saveTerceirizado(terc);
    }
}