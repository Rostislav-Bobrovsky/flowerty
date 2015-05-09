package by.itechart.flowerty.persistence.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QState is a Querydsl query type for State
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QState extends EntityPathBase<State> {

    private static final long serialVersionUID = -206759134L;

    public static final QState state = new QState("state");

    public final EnumPath<State.DESCRIPTION_TYPE> description = createEnum("description", State.DESCRIPTION_TYPE.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QState(String variable) {
        super(State.class, forVariable(variable));
    }

    public QState(Path<? extends State> path) {
        super(path.getType(), path.getMetadata());
    }

    public QState(PathMetadata<?> metadata) {
        super(State.class, metadata);
    }

}

