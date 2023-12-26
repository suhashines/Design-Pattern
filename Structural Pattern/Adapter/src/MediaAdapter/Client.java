package MediaAdapter;

public class Client {
    public static void main(String[] args) {
        
        MediaPlayer player = new AudioPlayer();

        player.play("mp3","audio.mp3");
        // in the previous version we could only play mp3 audio
        
        //but thanks to the adapater, now we can play mp4 and vlc too

        player.play("mp4","audio.mp4");
        player.play("vlc","audio.vlc");
        
    }
}
