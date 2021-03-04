/**  * @author Gabriel Woodburn - gwoodburn  * CIS175 - Spring 2021  * Mar 2, 2021  */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COMMENT_ID")
	private int id;
	@Column(name="COMMENT")
	private String comment;
	
	public Comment() 
	{
		super();
	}
	
	public Comment(int id, String comment) 
	{
		super();
		this.id = id;
		this.comment = comment;
	}
	
	public Comment(String comment)
	{
		super();
		this.comment = comment;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) 
	{
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", Comment=" + comment + "]";
	}
}
