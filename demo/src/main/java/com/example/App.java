package com.example;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpResponse;
import java.util.Scanner;

import org.json.*;

public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException, JSONException
    {
        System.out.println("Enter the name of the Game: ");
        Scanner scan = new Scanner(System.in);
        String game = scan.nextLine().toLowerCase();

        System.out.println("Enter your region: ");
        String region = scan.nextLine().toLowerCase();
        scan.close();

        System.out.println(" ");
        System.out.println("***************");
        System.out.println("Loading...");
        System.out.println("***************");
        System.out.println(" ");

        if(game.contains(" "))
        {
            game = game.replace(" ", "%20");
        }

        String gameid = getGameID(game, region);

        JSONObject jsonObj = get("https://game-prices.p.rapidapi.com/game/" +gameid +"?region=" +region +"&type=game");

        JSONArray storeList = jsonObj.getJSONArray("stores");
        GameInfo store1 = new GameInfo();
        GameInfo store2 = new GameInfo();
        GameInfo store3 = new GameInfo();
        GameInfo store4 = new GameInfo();

        store1 = infoSetter(storeList, gameid, store1, 1, 0);
        store2 = infoSetter(storeList, gameid, store2, 2, 1);
        store3 = infoSetter(storeList, gameid, store3, 3, 2);
        store4 = infoSetter(storeList, gameid, store4, 4, 3);

        System.out.println(" ");
        System.out.println("!!BEST PRICE!!");
        store1.printInfo();
        System.out.println(" ");
        store2.printInfo();
        System.out.println(" ");
        store3.printInfo();
        System.out.println(" ");
        store4.printInfo();
    }

    private static String getGameID(String game, String region) throws IOException, InterruptedException
    {
       JSONObject gameID = get("https://game-prices.p.rapidapi.com/games?title=" +game +"&region=" +region +"&offset=0&limit=10");

       JSONObject jsonArr = gameID.getJSONArray("games").getJSONObject(0);
       return jsonArr.getString("id");
    }

    private static GameInfo infoSetter(JSONArray list, String game, GameInfo store, int id, int index)
    {
        store.setID(id);
        store.setName(game);
        store.setSeller(list.getJSONObject(index).getString("seller"));
        store.setURL(list.getJSONObject(index).getString("url"));
        store.setPrice(list.getJSONObject(index).getFloat("price"));

        return store;
    }

    private static JSONObject get(String url) throws IOException, InterruptedException
    {
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create(url))
		.header("x-rapidapi-key", "e725d2cbe8msh5641a6076816446p1baffdjsnc0fb9add69dd")
		.header("x-rapidapi-host", "game-prices.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jsonObj = new JSONObject(response.body());

        return jsonObj;
    }
    /*
    private static void newAPI()
    {
        HttpRequest jsonResponse = Unirest.post("https://api.igdb.com/v4/games")
        .header("Client-ID", "Client ID")
        .header("Authorization", "Bearer access_token")
        .header("Accept", "application/json")
        .body("fields age_ratings,aggregated_rating,aggregated_rating_count,alternative_names,artworks,bundles,category,checksum,collection,cover,created_at,dlcs,expanded_games,expansions,external_games,first_release_date,follows,forks,franchise,franchises,game_engines,game_modes,genres,hypes,involved_companies,keywords,multiplayer_modes,name,parent_game,platforms,player_perspectives,ports,rating,rating_count,release_dates,remakes,remasters,screenshots,similar_games,slug,standalone_expansions,status,storyline,summary,tags,themes,total_rating,total_rating_count,updated_at,url,version_parent,version_title,videos,websites;")
        .asJson();
    }
    */
}