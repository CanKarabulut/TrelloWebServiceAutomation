package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Main {

    private static final String TOKEN = "ATTA5aa2bb21cb71eebe746c5972e8e0241eac9fa154ea9eb71fb4c15a71ce6bdc99319AD961";
    private static final String API_KEY = "cfe365fb197150ab886506b333ec0865";
    private static final String boardId = "63d42dc9be345eebd5f49b5f";
    private static final String cardId = "1";

    public static void main(String[] args) {
        RestAssured.baseURI = "https://api.trello.com";
        postRequest();
    }

    public static void postRequest() {
        Response createBoard = createBoard();
        Response board = getBoard(boardId);
        Response createCard = createCard(cardId);
        Response createAnotherCard = createCard(cardId);
        Response updateCard = updateCard(cardId);
        Response deleteCard = deleteCard(cardId);
        Response deleteBoard = deleteBoard(boardId);
    }

    private static Response createBoard() {
        return given()
                .header("Content-type", "application/json")
                .and()
                .queryParam("name", "can's boardd")
                .queryParam("key", API_KEY)
                .queryParam("token", TOKEN)
                .when()
                .post("/1/boards/")
                .then()
                .extract().response();
    }

    private static Response getBoard(String id) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .queryParam("key", API_KEY)
                .queryParam("token", TOKEN)
                .when()
                .get("/1/boards/" + id)
                .then()
                .extract().response();
    }

    private static Response deleteBoard(String boardID) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .queryParam("key", API_KEY)
                .queryParam("token", TOKEN)
                .when()
                .delete("/1/boards/" + boardID)
                .then()
                .extract().response();
    }

    private static Response createCard(String idList) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .queryParam("idList", idList)
                .queryParam("key", API_KEY)
                .queryParam("token", TOKEN)
                .when()
                .post("/1/cards/")
                .then()
                .extract().response();
    }

    private static Response updateCard(String id) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .queryParam("key", API_KEY)
                .queryParam("token", TOKEN)
                .when()
                .put("/1/cards/" + id)
                .then()
                .extract().response();
    }

    private static Response deleteCard(String id) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .queryParam("key", API_KEY)
                .queryParam("token", TOKEN)
                .when()
                .delete("/1/cards/" + id)
                .then()
                .extract().response();
    }
}