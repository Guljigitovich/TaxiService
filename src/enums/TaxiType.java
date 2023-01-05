package enums;

import java.math.BigDecimal;

public enum TaxiType {
    STANDART(new BigDecimal(20),new BigDecimal(130)),
    COMFORT(new BigDecimal(25),new BigDecimal(150)),
    BUSINESS(new BigDecimal(30),new BigDecimal(180));

    private BigDecimal pricePerKm;
    private BigDecimal priceForLanding;

    TaxiType(BigDecimal pricePerKm, BigDecimal priceForLanding) {
        this.pricePerKm = pricePerKm;
        this.priceForLanding = priceForLanding;
    }

    public BigDecimal getPricePerKm() {
        return pricePerKm;
    }

    public void setPricePerKm(BigDecimal pricePerKm) {
        this.pricePerKm = pricePerKm;
    }

    public BigDecimal getPriceForLanding() {
        return priceForLanding;
    }

    public void setPriceForLanding(BigDecimal priceForLanding) {
        this.priceForLanding = priceForLanding;
    }
}
