package jp.ac.gifu_u.info.lec.prog2.websurfer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Downloader {

    // ダウンロードした文字列を保持する。
    private String content = null;

    // ダウンロード禁止ドメインのリストを保持する。
    private ArrayList<String> bannedDomains = new ArrayList<>();

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

        // URL を設定して HTTP 通信を開始(メソッドは GET)
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");
        http.connect();

        // 受信したデータを読み出すためのストリームをオープン
        String text = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream(), "UTF-8"));

        // ストリームからデータを読み出し
        while (true) {
            String str = reader.readLine();
            if (str == null) {
                break;
            } else {
                text += str;
            }
        }

        this.content = text;
        return true;
    }

}
