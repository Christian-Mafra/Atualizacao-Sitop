package christian.mafra.org.robo;
//Christian Mafra
//Atualização Sitops

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    private static Robot robo;

    static {
        try {
            robo = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws AWTException, IOException, UnsupportedFlavorException {

        //Abrir email
        robo.mouseMove(560,750);
        Click(1);
        robo.delay(30000);

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
        robo.delay(10000);

        //---------------------------------------------------------
        //Puchando os Dados

        //Aba odn2
        //CopiarData(618,366, 676);
        //Colar(1150,115);
        //Copiando objetivo
        robo.mouseMove(300,524);
        Click(2);
        robo.delay(500);
        Copiar();
        Colar(900,115);
        AlterandoAba(320,25);

        //Aba odn1
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

        //COPIAR E COLAR NO TEAMS
        robo.mouseMove(1300,17);
        Click(1);
        robo.mouseMove(1,50);
        robo.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robo.mouseMove(2,170);
        robo.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
        Copiar();

        //FEICHANDO O DOCUMENTO .TXT
        robo.keyPress(KeyEvent.VK_ALT);
        robo.keyPress(KeyEvent.VK_F4);
        robo.keyRelease(KeyEvent.VK_ALT);
        robo.keyRelease(KeyEvent.VK_F4);
        robo.delay(500);

        //Abrindo o teams
        robo.mouseMove(612,752);
        Click(1);
        robo.delay(30000);
        robo.mouseMove(500,30);
        Click(1);
        robo.delay(500);
        robo.keyPress(KeyEvent.VK_D);
        robo.keyPress(KeyEvent.VK_A);
        robo.keyPress(KeyEvent.VK_I);
        robo.keyPress(KeyEvent.VK_L);
        robo.keyPress(KeyEvent.VK_Y);
        robo.delay(500);
        robo.mouseMove(700,180);
        Click(1);
        robo.delay(4000);
        Colar(700,660);


        /*
        ////////
        String frase, fraseNorbe6, FraseNorbe8, FraseNorbe9, FraseOdn1, FraseOdn2 = "null";
        String n6Data="null";
        String n6Objetivo="null";

        String n8Data = "null";
        String n8Objetivo = "null";

        String n9Data = "null";
        String n9Objetivo = "null";

        String od2Data = "null";
        String od2Objetivo = "null";

        String od3Data = "null";
        String od3Objetivo = "null";

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
            clipboard.getData(DataFlavor.stringFlavor).toString();
        }


       try {
            if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {*/
                //clipboard.getData(DataFlavor.stringFlavor).toString();

        /*   } else if (clipboard.isDataFlavorAvailable(DataFlavor.javaFileListFlavor)) {
                List<File> files = (List<File>) clipboard.getData(DataFlavor.javaFileListFlavor);

            } else if (clipboard.isDataFlavorAvailable(DataFlavor.imageFlavor)) {
                BufferedImage image = (BufferedImage) clipboard.getData(DataFlavor.imageFlavor);
            }

        } catch (UnsupportedFlavorException | IOException ufe) {
            Logger.getLogger(getClass().getName()).log(null, null, ufe);
        }

        frase = ("no6 - Término da intervenção previsto para "+ n6Data +" - "+ n6Objetivo +
                "no8 - Término da intervenção previsto para "+ n8Data +" - "+ n8Objetivo +
                "no9 - Término da intervenção previsto para "+ n9Data +" - "+ n9Objetivo +
                "no9 - Término da intervenção previsto para "+ n9Data +" - "+ n9Objetivo +
                "no9 - Término da intervenção previsto para "+ n9Data +" - "+ n9Objetivo );

                System.out.println(frase);

         */

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