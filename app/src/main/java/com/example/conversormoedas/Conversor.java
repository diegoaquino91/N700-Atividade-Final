package com.example.conversormoedas;

public class Length_Conversion {

    //variáveis para comparação de unidades
    final double meters = 1;
    final double centimeters = 100;
    final double kilometers = 0.001;
    final double miles = 0.0006214;

    //variáveis para inserção e saída de dados
    private double beginningQty;
    private double endingQty;
    private String beginningUnitType;
    private String endingUnitType;

    public Length_Conversion() {
        beginningQty = 0;
        endingQty = 0;
        beginningUnitType = "";
        endingUnitType = "";
    }
    public double getBeginningQty() {
        return beginningQty;
    }
    public void setBeginningQty(double beginningQty){
        this.beginningQty = beginningQty;
    }
    public double getEndingQty() {
        return endingQty;
    }
    public void setEndingQty(double endingQty) {
        this.endingQty = endingQty;
    }
    public String getBeginningUnitType() {
        return beginningUnitType;
    }
    public void setBeginningUnitType(String beginningUnitType) {
        this.beginningUnitType = beginningUnitType;
    }
    public String getEndingUnitType() {
        return endingUnitType;
    }
    public void setEndingUnitType(String endingUnitType) {
        this.endingUnitType = endingUnitType;
    }
    public double getUnitTypeConstant(String unitType){
        if(unitType == "meters"){return meters;}
        if(unitType == "centimeters"){return centimeters;}
        if(unitType == "kilometers"){return kilometers;}
        if(unitType == "miles"){return miles;}
        return 0;
    }

    public double calculateEndingQty(){
        //declarar e iniciar variáveis
        double beginningQty = getBeginningQty();
        double endingQty = getEndingQty();
        double beginninUnitType = getUnitTypeConstant(getBeginningUnitType());
        double endingUnitType = getUnitTypeConstant(getEndingUnitType());

        //converter para metros
        endingQty = meters/beginninUnitType;

        //converter de metros
        endingQty = endingQty * endingUnitType;

        //multiplicar pela quantidade inicial para obter o resultado final
        endingQty = endingQty * beginningQty;

        return endingQty;
    }
}
