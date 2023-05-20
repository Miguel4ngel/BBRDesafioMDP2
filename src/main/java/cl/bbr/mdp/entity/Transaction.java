package cl.bbr.mdp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Cacheable(true)
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactions")
public class Transaction implements Serializable {

	private static final long serialVersionUID = -5454315670915840467L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id" )
	private Long id;
	
	@Column(name = "commerce" )
	private String commerce;
	
	@Column(name = "amount")
	private Integer amount;

	@Column(name = "type")
	private String type;

	@Column(name = "createdAt")
	private String createdAt;

	@Column(name = "user")
	private String user;

}