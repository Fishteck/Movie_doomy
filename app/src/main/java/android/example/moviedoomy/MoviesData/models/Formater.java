package android.example.moviedoomy.MoviesData.models;

import android.example.moviedoomy.MoviesData.entity.GenreJSONResult;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Formater {

    public static String formatGenre(Map<Integer, String> genresMap, List<Integer> genresIds) {
        String tmp = "";
        int i = 0;
        for (int el : genresIds) {
            if (genresMap.containsKey(el)) {
                if (i == 2) break;
                tmp += genresMap.get(el) + ",";
                i++;
            }
        }
        return tmp.substring(0, tmp.length() - 1);
    }

    public static String formatDate(String releaseDate) {
        String formatDate = "";
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(releaseDate);
            formatDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
            return formatDate;
        } catch (ParseException ex) {
            Log.d("formatDate", ex.getClass().getSimpleName());
        }
        return formatDate;
    }

    public static String formatGenre(List<GenreJSONResult> list) {
        String tmp = "";

        for (GenreJSONResult el : list) {
            tmp += el.getName() + ",";
        }
        return tmp.substring(0, tmp.length() - 1);
    }

}
