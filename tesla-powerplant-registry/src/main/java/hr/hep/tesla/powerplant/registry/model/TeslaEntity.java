package hr.hep.tesla.powerplant.registry.model;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@MappedSuperclass
public abstract class TeslaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Version
	private Timestamp updated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(nullable = false)
	private boolean archived = false;

	@PrePersist
	protected void onCreate()
	{
		created = new Date();
	}
	
	public Timestamp getUpdated()
	{
		return updated;
	}

	public void setUpdated(Timestamp updated)
	{
		this.updated = updated;
	}

	public Date getCreated()
	{
		return created;
	}

	public void setCreated(Date created)
	{
		this.created = created;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}
	
}