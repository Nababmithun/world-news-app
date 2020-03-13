package com.example.worldnewsapp.Common;


import com.example.worldnewsapp.Interface.IconBetterIdeaService;
import com.example.worldnewsapp.Interface.NewsService;
import com.example.worldnewsapp.Remote.IconBetterIdeaClient;
import com.example.worldnewsapp.Remote.RetrofitClient;

public class Common {
    private static final String BASE_URL="https://newsapi.org/";

    public  static final String API_KEY="bfd2248af44f4f00a9ae3ce5f7233cbf";

    public static NewsService getNewsService()
    {
        return RetrofitClient.getClient(BASE_URL).create(NewsService.class);
    }

    public static IconBetterIdeaService getIconService()
    {
        return IconBetterIdeaClient.getClient().create(IconBetterIdeaService.class);
    }

    public static String getAPIUrl(String source,String sortBy,String apiKEY)
    {
        StringBuilder apiUrl = new StringBuilder("https://newsapi.org/v2/top-headlines?sources=");
        return apiUrl.append(source)
                .append("&apiKey=")
                .append(apiKEY)
                .toString();
    }


}
