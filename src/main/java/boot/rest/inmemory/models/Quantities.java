package boot.rest.inmemory.models;

import java.math.BigInteger;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Quantities {
    private final String lastUpdated;
	private final BigInteger values;    
}