package christian.mafra.org.robo;
//Christian Mafra
//Atualização Sitops

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Main {
    private static Robot robo;

    static {
        try {
            robo = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws AWTException {

        //Abrir email
        robo.mouseMove(560,750);
        Click(1);
        robo.delay(3000);

        //Mais opções p/ acessar as pastas
        ClickMais();

        //Sitop norbe8
        Sitop(400, 210);
        EscolherSitopDoDia(1);
        AbrirArquivo(1);
        ClickMais();

        //sitop norbe9
        Sitop( 400,380);
        EscolherSitopDoDia(0);
        AbrirArquivo(0);
        ClickMais();

        //Sitop ODN1
        Sitop(400,545);
        EscolherSitopDoDia(0);
        AbrirArquivo(0);
        ClickMais();

        //Sitop ODN2
        Sitop(400,715);
        EscolherSitopDoDia(0);
        AbrirArquivo(0);

        //minimizar email
        robo.mouseMove(1250, 15);
        Click(1);

        //Abrir arquivo SITOP
        robo.mouseMove(1320, 140);
        robo.delay(500);
        Click(2);
        robo.delay(5000);

        //---------------------------------------------------------
        //Puchando os Dados

        //Aba odn2
        CopiarData(618,366, 676);
        Colar(1150,115);
        //Copiando objetivo
        robo.mouseMove(300,524);
        Click(2);
        Copiar();
        Colar(1260,115);

        //Aba odn1
        AlterandoAba(320,25);
        CopiarData(620,355, 680);
        Colar(1150,97);
        robo.mouseMove(280,524);
        Click(2);
        Copiar();
        Colar(1260,95);

        //Aba norbe9
        AlterandoAba(250,25);
        CopiarData(624,364, 682);
        Colar(1150,78);
        robo.mouseMove(270,520);
        Click(2);
        Copiar();
        Colar(1260,80);

        //Aba norbe8
        AlterandoAba(150,25);
        CopiarData(621,364, 676);
        Colar(1150,60);
        robo.mouseMove(280,520);
        Click(2);
        Copiar();
        Colar(1260,65);

        //SALVANDO DOCUMENTO .TXT
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_S);
        robo.keyRelease(KeyEvent.VK_CONTROL);
        robo.keyRelease(KeyEvent.VK_S);

        //FEICHANDO O DOCUMENTO .TXT
        robo.keyPress(KeyEvent.VK_ALT);
        robo.keyPress(KeyEvent.VK_F4);
        robo.keyRelease(KeyEvent.VK_ALT);
        robo.keyRelease(KeyEvent.VK_F4);

    }

    private static void Copiar() {
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_C);
        robo.keyRelease(KeyEvent.VK_CONTROL);
        robo.keyRelease(KeyEvent.VK_C);
        robo.delay(500);
    }

    private static void Colar(int x, int y) {
        robo.mouseMove(x, y);
        Click(2);
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_V);
        robo.keyRelease(KeyEvent.VK_CONTROL);
        robo.keyRelease(KeyEvent.VK_V);
        robo.keyPress(KeyEvent.VK_SPACE);
        robo.delay(500);
    }
    public static void ClickMais() {
        robo.delay(1000);
        //mover o mouse para botao "mais"
        robo.mouseMove(60, 455);
        Click(1);
        robo.delay(1000);
        //mover o mouse para borra de rolagem
        robo.mouseMove(613, 580);
        robo.delay(500);
        Click(1);
        robo.delay(500);
    }
    public static void AbrirArquivo(int i) {

        robo.mouseMove(747, 250);
        Click(1);
        if(i==1){
            robo.delay(7000);
        }else{
            robo.delay(1000);
        }
        robo.mouseMove(1020, 230);
        Click(1);
        robo.delay(50);

    }
    public static void EscolherSitopDoDia(int i) {
        robo.delay(2000);
        robo.mouseMove(490, 180);
        Click(1);
        robo.delay(6000);
        robo.mouseMove(1358, 105);
        Click(1);
        robo.delay(1000);
    }
    public static void Sitop(int x, int y) {
        robo.mouseMove(x, y);
        Click(1);
        robo.delay(3000);
    }
    public static void AlterandoAba(int x, int y){
        robo.mouseMove(x,y);
        Click( 1);
        robo.delay(500);
    }
    public static void CopiarData(int x1, int y, int x2){
        robo.mouseMove(x1, y);
        robo.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robo.mouseMove(x2, y);
        robo.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
        Copiar();
    }
    public static void Click(int i){
        while (i != 0){
            robo.delay(10);
            robo.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robo.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            --i;
        }
    }
}