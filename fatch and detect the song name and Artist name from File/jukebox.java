/**
 *
 * @author Bilakhiya
 */
import java.util.*;
import java.io.*;

class jukebox {

    ArrayList<String> songList = new ArrayList<String>();
    ArrayList<String> Artist = new ArrayList<String>();

    public void go() {
        read_mixFile();
        getSongs();
        getArtist();

        System.out.println("---------------------------------------");
        System.out.println(songList);
        System.out.println("---------------------------------------");
        System.out.println(Artist);
        System.out.println("---------------------------------------");
    }

    public void read_mixFile() {
        try {
            BufferedReader br = file_read();
            String line = null;
            System.out.println("---------------------------------------");
            System.out.println("File Data:");
            System.out.println("---------------------------------------");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("---------------------------------------");
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getArtist() {
        try {
            BufferedReader br = file_read();
            String line = null;

            while ((line = br.readLine()) != null) {
                addArtist(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getSongs() {
        try {
            BufferedReader br = file_read();
            String line = null;
            while ((line = br.readLine()) != null) {
                addSong(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addSong(String line) {
        String song_name[] = line.split("/");
        songList.add(song_name[0]);
    }

    public void addArtist(String line) {
        String Artist_name[] = line.split("/");
        Artist.add(Artist_name[1]);
    }

    public BufferedReader file_read() throws Exception {

        File f1 = new File("songList.txt");
        BufferedReader br = new BufferedReader(new FileReader(f1));
        return br;
    }

    public static void main(String[] args) throws Exception {
        new jukebox().go();
    }

}
