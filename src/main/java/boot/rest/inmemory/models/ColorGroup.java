package boot.rest.inmemory.models;

import lombok.Getter;

@Getter
public class ColorGroup extends Group {

    private Colors color;
    public ColorGroup(Long count, Colors color) {
        super(count);
        this.color = color;
    }

}
