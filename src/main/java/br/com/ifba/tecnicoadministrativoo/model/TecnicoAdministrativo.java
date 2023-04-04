package br.com.ifba.tecnicoadministrativoo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.ifba.servidor.model.Servidor;
import lombok.Data;

@Entity
@Table(name = "tecnicoadminstrativo")
@Data
public class TecnicoAdministrativo extends Servidor implements Serializable{
    
}
