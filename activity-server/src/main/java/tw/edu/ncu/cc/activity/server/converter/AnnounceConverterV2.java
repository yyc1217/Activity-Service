package tw.edu.ncu.cc.activity.server.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;
import tw.edu.ncu.cc.activity.data.v2.Announce;
import tw.edu.ncu.cc.activity.server.entity.AnnounceEntity;

public class AnnounceConverterV2 implements Converter< AnnounceEntity, Announce > {

    private String attachmentPrefix = "";

    public void setAttachmentPrefix( String attachmentPrefix ) {
        this.attachmentPrefix = attachmentPrefix;
    }

    @Override
    public Announce convert( AnnounceEntity source ) {
        Announce announce = new Announce();
        announce.setId( source.getId() );
        announce.setTime( source.getTime() );
        announce.setTitle( source.getTitle() );
        announce.setContent( source.getContent() );
        if( ! StringUtils.isEmpty( source.getAttachment() ) ) {
            announce.setAttachment( attachmentPrefix + source.getAttachment() );
        }
        return announce;
    }

}
