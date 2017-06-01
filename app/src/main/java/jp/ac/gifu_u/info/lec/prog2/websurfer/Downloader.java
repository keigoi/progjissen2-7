package jp.ac.gifu_u.info.lec.prog2.websurfer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Downloader {

    // ダウンロードした文字列を保持する。
    private String content = null;

    // ダウンロード禁止ドメインのリストを保持する。
    private List<String> bannedDomains = new ArrayList<>();

    /**
     * 直前のダウンロードが成功していればダウンロードした内容を、失敗していれば null を返す
     * @return ダウンロードした文字列
     */
    public String getContent() {
        return content;
    }

    /**
     * 禁止ドメインを追加する。
     * @param domain 追加するドメイン
     */
    public void addBannedDomain(String domain) {
        // TODO ここを埋める
    }

    /**
     * 禁止ドメインを削除する。
     * @param domain 削除するドメイン
     */
    public void removeBannedDomain(String domain) {
        // TODO ここを埋める
    }

    /**
     * 与えられた URL からファイルをダウンロードする
     * @param urlstr URL文字列
     * @return ダウンロードに成功すれば true, 禁止されたドメインであれば false
     * @throws IOException ダウンロード途中でエラーが発生した場合
     */
    public boolean download(String urlstr) throws IOException {
        URL url = new URL(urlstr);

        // TODO url.getHost() が bannedDomains のどれかで終わるときに false を返す処理を入れる
        // url.getHost().endsWith(禁止文字列)

        // URL を設定して HTTP 通信を開始
        HttpURLConnection http = (HttpURLConnection) url.openConnection();

        // 受信したデータを読み出すためのストリームをオープン
        Scanner scanner = new Scanner(http.getInputStream(), "UTF-8");

        // スキャナーからデータを読み出し
        String text = "";
        while (scanner.hasNextLine()) {
            text += scanner.nextLine();
        }

        this.content = text;

        scanner.close();
        http.disconnect();

        return true;
    }
}
