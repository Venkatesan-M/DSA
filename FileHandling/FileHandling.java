package FileHandling;

// lib for filehandling
import java.io.*;

public class FileHandling {
    public static void main(String[] args) throws IOException {
        
        /*
         * Steams --> Sequence of data
         * abstraction provided by java
         * 
         *                                       Streams in Java
         *                    |--------------------------|-----------------------|
         *                Byte Stream                                    Character Stream
         *        |-----------|--------------|               |-------------------|----------------|
         *   Input Stream              Output Stream       Reader                               Writer
         * 
         * 
         * Predefined Streams:
         * System.out --> std os --> console (Print Stream)
         * System.in  --> std is --> keyboard (Input Stream)
         * System.err --> std err --> console (Print Stream)
         */


        // Getting the Byte stream to Character Stream

        try(InputStreamReader isr = new InputStreamReader(System.in)){
            System.out.println("Enter some letters");
            int letters = isr.read();
            while(isr.ready()){
                System.out.println((char)(letters));
                letters = isr.read();
            }
            // automatically closed in try, catch, below statement is not needed
            isr.close();
            System.out.println();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }


        // getting the input from the file

        try(FileReader fr = new FileReader("/workspace/DSA/FileHandling/notes.txt")){
            int letters = fr.read();
            while(fr.ready()){
                System.out.print((char)(letters));
                letters = fr.read();
            }
            // automatically closed in try, catch, below statement is not needed
            fr.close();
            System.out.println();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

        // byte to char stream and then reading char stream
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("you typed: "+br.readLine());
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

        try(BufferedReader br = new BufferedReader(new FileReader("/workspace/DSA/FileHandling/notes.txt"))){
            System.out.println("you typed: "+br.readLine());
        } catch(IOException e){
            System.out.println(e.getMessage());
        }



        // output

        // OutputStream os = System.out;
        // os.write(😊);
        
        try(OutputStreamWriter osw = new OutputStreamWriter(System.out)){
            osw.write("hello");
            osw.write(32);
            osw.write('a');
            char[] ass = {'a', 's', 's'};
            osw.write(ass);

        } catch(IOException e){
            System.out.println(e.getMessage());
        }


        try(FileWriter fw = new FileWriter("/workspace/DSA/FileHandling/notes.txt", true)){
            fw.write("22BAI1259");
            fw.write("Venkatesan M");
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("/workspace/DSA/FileHandling/notes.txt", true))){
            bw.write("22BAI1259");
            bw.write("Venkatesan M");
        } catch(IOException e){
            System.out.println(e.getMessage());
        }



        // new file
        try{
            File fo = new File("/workspace/DSA/FileHandling/file.txt");
            fo.createNewFile();
            if(fo.delete()) System.out.println(fo.getName());;
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

        // writer

        try(FileWriter fw = new FileWriter("/workspace/DSA/FileHandling/file.txt", true)){
            fw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eu arcu libero. Duis sit amet dolor sit amet ante hendrerit egestas vitae id ex. Pellentesque eu nibh sed ante placerat imperdiet. Curabitur a libero vel nunc pulvinar porttitor a sed dolor. Duis vel ligula non sem vestibulum maximus. Duis ut est ut diam viverra dignissim. Ut sollicitudin elit est, eu hendrerit quam gravida vitae. Curabitur mollis dignissim semper. Ut rutrum iaculis urna eget varius. Nunc ultricies maximus enim. Pellentesque at aliquam nisl. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Morbi feugiat auctor suscipit.\r\n" + //
                                "\r\n" + //
                                "Mauris eu hendrerit sem. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Maecenas eu eleifend turpis. Sed tincidunt ante nulla, vitae dictum turpis cursus sed. Quisque semper at nulla quis rhoncus. Maecenas vehicula vehicula nisl, et rhoncus diam venenatis a. Nam tellus odio, congue vitae lectus non, fringilla vestibulum velit. Ut luctus condimentum lectus, ac vulputate orci gravida eget. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Vestibulum auctor est lobortis libero feugiat dignissim. Sed maximus non sem eu aliquam. Maecenas non tortor lobortis, suscipit tortor ut, pharetra nisi.\r\n" + //
                                "\r\n" + //
                                "Nam purus sem, mollis eu porta id, maximus ac nisl. Nam ut magna non eros consequat euismod. Etiam semper erat varius lorem suscipit faucibus. Ut semper quis ipsum quis ullamcorper. Cras odio nisl, fringilla in metus in, imperdiet faucibus lacus. Nulla et suscipit massa. Mauris condimentum ligula sed nunc dignissim eleifend at vel quam. In sit amet nibh aliquam, euismod quam id, tempus nibh.\r\n" + //
                                "\r\n" + //
                                "Praesent ac felis id massa vulputate cursus. Pellentesque nec commodo ligula. Nunc facilisis luctus pharetra. Cras vitae dolor porttitor, mollis velit id, efficitur ex. Vestibulum id arcu congue, sagittis nisi non, molestie diam. Duis in magna id risus bibendum placerat. Nam eget varius dui.\r\n" + //
                                "\r\n" + //
                                "Aliquam erat volutpat. Nullam venenatis, sem id rutrum tristique, ex diam semper nunc, non molestie risus lorem at justo. Curabitur at interdum dolor, vel auctor ligula. Curabitur mauris enim, bibendum id arcu at, sodales sagittis sapien. Nulla sapien lorem, volutpat id diam ut, placerat tempor magna. Morbi eu augue lacinia, lobortis enim eget, viverra nibh. Duis eu congue neque. Curabitur eu urna id lorem mollis accumsan eget id mi. Vivamus placerat risus ut viverra efficitur. Nullam purus magna, fermentum a dui at, placerat vestibulum ex.");        
        
        } catch(IOException e){
            System.out.println(e.getMessage());
        }


        try(FileReader fr = new FileReader("/workspace/DSA/FileHandling/file.txt")){
            int letters = fr.read();
            while(fr.ready()){
                System.out.print((char)(letters));
                letters = fr.read();
            }
            System.out.println();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
