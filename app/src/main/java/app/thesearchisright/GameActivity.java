package app.thesearchisright;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Lachlan on 18/05/2017.
 */
public class GameActivity  extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);

        String data = getIntent().getExtras().getString("Q");
        resultGet(data);

//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    String resultGet(String q)
    {

//        String path = getFilesDir().getAbsolutePath();
//        File input = new File(getFilesDir() + "/tmp.html");
//
//        if (!input.exists()) {
//            try {
//                input.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        try {
//            Document doc = Jsoup.parse(input, "UTF-8", "http://google.com/search?q=" + q);
//            Element content = doc.getElementById("resultStats");
//            q = content.text();
            Retrive r = new Retrive();
            r.getRes(q);
            return q;
        }catch (IOException i){
            Toast t = Toast.makeText(this, R.string.IOErrorToast, Toast.LENGTH_SHORT);
            t.show();
        }
//http://jsoup.org/cookbook/input/load-document-from-url
//Document doc = Jsoup.connect("http://example.com/").get();


        return q;
    }
}

// class Retrieve extends AsyncTask<String, Void, org.w3c.dom.Document> {
//
//    private Exception exception;
//
//    protected org.w3c.dom.Document doInBackground(String... urls) {
//        try {
//            URL url = new URL(urls[0]);
//            SAXParserFactory factory = SAXParserFactory.newInstance();
//            SAXParser parser = factory.newSAXParser();
//            XMLReader xmlreader = parser.getXMLReader();
//            RssHandler theRSSHandler = new RssHandler();
//            xmlreader.setContentHandler(theRSSHandler);
//            InputSource is = new InputSource(url.openStream());
//            xmlreader.parse(is);
//
//            return theRSSHandler.getFeed();
//        } catch (Exception e) {
//            this.exception = e;
//
//            return null;
//        }
//    }
//
//    protected void onPostExecute(RSSFeed feed) {
//        // TODO: check this.exception
//        // TODO: do something with the feed
//    }
//}