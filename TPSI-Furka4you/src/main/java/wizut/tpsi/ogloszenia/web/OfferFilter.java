package wizut.tpsi.ogloszenia.web;

public class OfferFilter {
    private Integer manufacturerId;
    private Integer modelId;
    private Integer minYear;
    private Integer maxYear;
    private Integer fuelType;

    
    public Integer getManufacturerId() {
        return manufacturerId;
    }

    
    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    
    public Integer getModelId() {
        return modelId;
    }

    
    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

   
    public Integer getMinYear() {
        return minYear;
    }

    
    public void setMinYear(Integer minYear) {
        this.minYear = minYear;
    }

  
    public Integer getMaxYear() {
        return maxYear;
    }

    
    public void setMaxYear(Integer maxYear) {
        this.maxYear = maxYear;
    }

    
    public Integer getFuelType() {
        return fuelType;
    }

    
    public void setFuelType(Integer fuelType) {
        this.fuelType = fuelType;
    }
}
