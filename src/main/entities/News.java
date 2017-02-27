package main.entities;

import org.omnifaces.cdi.GraphicImageBean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


//class nature for hibernate
@GraphicImageBean //to display image from the database
@Entity
@NamedQuery(name = "FIND_ALL",query = "SELECT p FROM News p")
public class News implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;

	@Column(length = 100,nullable = false)
	private String header;

	//created automatically in the constructor
	@Temporal(value = TemporalType.DATE)
	private Date date;

	@Column(length = 1000,nullable = false)
	private String body;

	//image storage
	private byte[] image;

	public News(){
		this.date=new Date();
	}

	public News(String header, String body) {
		this.header = header;
		this.date=new Date();
		this.body = body;
	}

	//getters and setters
	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
