package co.edu.polijic.taller.mappers;

import co.edu.polijic.taller.model.dto.BacklogDto;
import co.edu.polijic.taller.model.dto.BacklogDto.BacklogDtoBuilder;
import co.edu.polijic.taller.model.entity.Backlog;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-30T14:08:10-0500",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_261 (Oracle Corporation)"
)
@Component
public class BacklogMapperImpl implements BacklogMapper {

    @Override
    public BacklogDto from(Backlog backlog) {
        if ( backlog == null ) {
            return null;
        }

        BacklogDtoBuilder backlogDto = BacklogDto.builder();

        return backlogDto.build();
    }

    @Override
    public Backlog to(BacklogDto backlogDto) {
        if ( backlogDto == null ) {
            return null;
        }

        Backlog backlog = new Backlog();

        return backlog;
    }
}
