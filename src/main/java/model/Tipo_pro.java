package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_productos")
@Data
public class Tipo_pro {
	@Id
	private String id_pro;

}
