package boot.rest.inmemory.models;

import lombok.Getter;

@Getter
public class SizeGroup extends Group {
    private Size size;

    public SizeGroup(Long count, Size size) {
        super(count);
        this.size = size;
    }
}
