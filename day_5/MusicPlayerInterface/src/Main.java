import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

interface MusicPlayer{
    void play();

    void playBack();

    void playNext();

    void pause();

    void stop();

    void addSong(String song);

    void remove(String song);
}

class MyMusicPlayer implements MusicPlayer {
    private int current;
    private List<String> songList;

    MyMusicPlayer() {
        this.current = current;
        this.songList = new ArrayList<>();
    }

    @Override
    public void play() {
        if(!this.songList.isEmpty()) {
            String currentSong = this.songList.get(this.current);
            System.out.println("Now playing: `" + currentSong + "`.");
        }
        else {
            System.out.println("Playlist is empty.");
        }
    }

    @Override
    public void playBack() {
        if(this.songList.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else if(this.current != 0) {
            this.current -= 1;
            play();
        } else {
            this.current = this.songList.size() - 1;
            play();
        }
    }

    @Override
    public void playNext() {
        if(this.songList.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else if(this.current != this.songList.size() - 1) {
            this.current += 1;
            play();
        } else {
            this.current = 0;
            play();
        }
    }

    @Override
    public void pause() {
        if(!this.songList.isEmpty()) {
            String currentSong = this.songList.get(this.current);
            System.out.println("Pause: `" + currentSong + "`.");
        } else {
            System.out.println("Playlist is empty.");
        }
    }

    @Override
    public void stop() {
        this.current = 0;
    }

    @Override
    public void addSong(String song) {
        if(this.songList.contains(song)) {
            System.out.println("Playlist already contains `" + song + "`.");
        } else {
            this.songList.add(song);
            System.out.println("Added `" + song + "` to playlist.");
        }
    }

    @Override
    public void remove(String song) {
        if(songList.contains(song)) {
            this.songList.remove(song);
            System.out.println("Removed `" + song + "` form playlist.");
        } else {
            System.out.println("Playlist does not have `" + song + "`.");
        }
    }


}

public class Main {
    public static void main(String[] args) {
        MyMusicPlayer mPlayer = new MyMusicPlayer();
        while(true) {
            System.out.println("------ My Music Player ------");
            System.out.println("=============================");
            System.out.println("Press the following options");
            System.out.println("1- play current music");
            System.out.println("2- play next music");
            System.out.println("3- play previous music");
            System.out.println("4- pause current music");
            System.out.println("5- stop playlist");
            System.out.println("6- add a song to playlist");
            System.out.println("7- remove a song from playlist");
            System.out.println("0- Exit My Music Player");
            String song;
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            sc.nextLine(); // consumes newline character
            switch(option) {
                case 0:
                    System.out.println("Switching OFF, SEE YA!");
                    sc.close();
                    System.exit(0);
                    break;
                case 1:
                    mPlayer.play();
                    break;
                case 2:
                    mPlayer.playNext();
                    break;
                case 3:
                    mPlayer.playBack();
                    break;
                case 4:
                    mPlayer.pause();
                    break;
                case 5:
                    mPlayer.stop();
                    break;
                case 6:
                    song = sc.nextLine();
                    if(song.isEmpty() || song.trim().isEmpty()) {
                        System.out.println("song name entered is empty.");
                    } else {
                        mPlayer.addSong(song);
                    }
                    break;
                case 7:
                    song = sc.nextLine();
                    if(song.isEmpty() || song.trim().isEmpty()) {
                        System.out.println("song name entered is empty.");
                    } else {
                        mPlayer.remove(song);
                    }
                    break;
                default:
                    System.out.println("incorrect choice! please enter a number between 0 - 6");
                    break;
            }
        }
    }

}