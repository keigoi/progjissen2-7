package jp.ac.gifu_u.info.lec.prog2.websurfer;

import junit.framework.TestCase;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Downloader クラスのユニットテスト
 * Created by keigoi on 2017/05/30.
 */
public class DownloaderTest {

    /*
     * 何も前提がなければダウンロードが成功することを確認するテスト
     */
    @Test
    public void download_success() throws Exception {
        Downloader d = new Downloader();

        // download メソッドが true を返し、getContent は 非 null のはず
        assertTrue( d.download("http://example.com/") );
        assertNotNull( d.getContent() );
    }

    /*
     * 禁止された URL で download() が false を返すことを確認するテスト
     */
    @Test
    public void addBanned_download_banned() throws Exception {
        Downloader d = new Downloader();

        d.addBannedDomain("example.com");

        assertFalse( d.download("http://bad.example.com/index.html") );
        assertNull( d.getContent() );
    }

    /*
     * removeBanned で禁止 URL から外れることを確認するテスト
     */
    @Test
    public void removeBanned_download_success() throws Exception {
        // TODO テストを書く。ダウンロード URL は "http://example.com/" 等を使う
    }

}
