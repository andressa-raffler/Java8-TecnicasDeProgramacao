package com.LetsCode.A1APIdateTime;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainDateTime {

    public static void main(String[] args) {
        //exemplosDatas();
       // calcularIdade();
        zonasFusos();
    }

    public static void exemplosDatas(){
        LocalDate localDate = LocalDate.now();

        LocalDate dataManual = LocalDate.of(2022,12,30);
        System.out.println("Nome do mes :"+dataManual.getMonth().name());

       LocalDate dateFromString = LocalDate.parse("1988-11-12");
        System.out.println("Data digitada: "+dateFromString.toString());

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataAniversario = LocalDate.parse("01/02/2022",formato);

        Period period = Period.between(dataManual, dateFromString);
        System.out.println(period.toString());
    }

    public static void calcularIdade(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a sua data de nascimento dd/mm/yyyy");
        String nascimento = sc.next();
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataAniversario = LocalDate.parse(nascimento,formatar);
        Period period = Period.between(dataAniversario, LocalDate.now());
        System.out.println("Idade: "+period.getYears()+" anos, "+period.getMonths()+" meses, "+period.getDays()+" dias");



    }
    //ler do console a data de nascimento e mostrar quantos anos, meses e dias ela tem

    public static void zonasFusos(){
        ZoneId fusoLA = ZoneId.of("America/Los_Angeles");
        ZonedDateTime horaLA = ZonedDateTime.of(LocalDateTime.now(), fusoLA);
        LocalDateTime dataHoraLosAngeles = LocalDateTime.of(2022, Month.JUNE, 20,22,00,00);


        ZoneId fusoSaoPaulo = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime horaSaoPaulo = ZonedDateTime.of(LocalDateTime.now(), fusoSaoPaulo);
        System.out.println("Hora sao paulo :"+horaSaoPaulo);

        Duration diferenca = Duration.between(horaLA,horaSaoPaulo);
        System.out.println("Diferenca de horas entre LA e SP :"+diferenca.toHours());
        System.out.println(ZoneId.systemDefault());


    }



}
