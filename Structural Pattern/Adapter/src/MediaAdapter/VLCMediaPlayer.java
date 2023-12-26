package MediaAdapter;

public class VLCMediaPlayer implements AdvanceMediaPlayer{
    
    @Override
    public void playVLC(String fileName) {
        System.out.println("playing VLC file " + fileName);
    }

    @Override
    public void playMP4(String fileName) {
        //do nothing
    }
}
