package ejercicioEnClase;

public class MetodosBeca {
    Utils utils;
    public MetodosBeca(Utils utils) {
        this.utils = utils;
    }
    public String recomendacionBeca(String ci){
        String msg="";
        if(Helpers.aplicaBeca(ci)){
            if(utils.getNota(ci)>=90){
                msg="SI APLICA A BECA";
            }else{
                msg="NO APLICA A BECA POR PROMEDIO ACADEMICO";
            }
        }else{
            msg="EL ESTUDIANTE NO CURSO AUN EL 60% DE LAS MATERIAS";
        }
        return msg;
    }
}
