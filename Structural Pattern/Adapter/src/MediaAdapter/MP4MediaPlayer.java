package MediaAdapter;

public class MP4MediaPlayer implements AdvanceMediaPlayer{

    @Override
    public void playMP4(String fileName) {
        System.out.println("playing MP4 file " + fileName);
    }

    @Override
    public void playVLC(String fileName) {
        //do nothing
    }
    
}
