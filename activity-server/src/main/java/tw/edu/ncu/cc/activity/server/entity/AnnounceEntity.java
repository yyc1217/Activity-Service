package tw.edu.ncu.cc.activity.server.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "news" )
public class AnnounceEntity {

    private int id;
    private boolean major;
    private boolean isDisabled;
    private String type;
    private String title;
    private String content;
    private Date time;
    private Date deadTime;
    private String attachment;

    @Id
    @Column( name = "NewsID" )
    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    @Basic
    @Column( name = "major" )
    public boolean isMajor() {
        return major;
    }

    public void setMajor( boolean major ) {
        this.major = major;
    }

    @Basic
    @Column( name = "disable" )
    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled( boolean isDisabled ) {
        this.isDisabled = isDisabled;
    }

    @Basic
    @Column( name = "NewsType" )
    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

    @Basic
    @Column( name = "Title" )
    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    @Basic
    @Column( name = "Content" )
    public String getContent() {
        return content;
    }

    public void setContent( String content ) {
        this.content = content;
    }

    @Basic
    @Column( name = "Time" )
    public Date getTime() {
        return time;
    }

    public void setTime( Date time ) {
        this.time = time;
    }

    @Basic
    @Column( name = "DeadTime" )
    public Date getDeadTime() {
        return deadTime;
    }

    public void setDeadTime( Date deadTime ) {
        this.deadTime = deadTime;
    }

    @Basic
    @Column( name = "upfile" )
    public String getAttachment() {
        return attachment;
    }

    public void setAttachment( String attachment ) {
        this.attachment = attachment;
    }



}
