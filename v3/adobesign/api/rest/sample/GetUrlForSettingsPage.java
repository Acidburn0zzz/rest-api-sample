/*************************************************************************
 * ADOBE SYSTEMS INCORPORATED
 * Copyright 2015 Adobe Systems Incorporated
 * All Rights Reserved.
 * 
 * NOTICE: Adobe permits you to use, modify, and distribute this file in accordance with the
 * terms of the Adobe license agreement accompanying it. If you have received this file from a
 * source other than Adobe, then your use, modification, or distribution of it requires the prior
 * written permission of Adobe.
 **************************************************************************/

package adobesign.api.rest.sample;

import org.json.simple.JSONObject;

import adobesign.api.rest.sample.util.FileUtils;
import adobesign.api.rest.sample.util.RestApiOAuthTokens;
import adobesign.api.rest.sample.util.RestApiUtils;
import adobesign.api.rest.sample.util.RestApiViews;

/**
 * This sample client demonstrates how to get URL for Settings page. The URL can be generated for two type of settings page.
 * One is the URL for user profile page which can be generated for any kind of user, and the other is the URL for
 * account settings page which can be generated for account administrators only.
 * <p>
 * <b>IMPORTANT</b>: Before running this sample, check that you have modified the JSON file 'OAuthCredentials.json' and 'GetUrlForSettingsPage.json'
 * with appropriate values. Which values need to be specified is indicated in the file.
 * </p>
 */
public class GetUrlForSettingsPage {

  // File containing request body to get an access token.
  private static final String authRequestJSONFileName = "OAuthCredentials.json";

  // File containing the request body to make the API call.
  private final static String viewUrlRequestJSONFileName = "GetUrlForSettingsPage.json";

  /**
   * Entry point for this sample client program.
   */
  public static void main(String args[]) {
    try {
      GetUrlForSettingsPage client = new GetUrlForSettingsPage();
      client.run();
    }
    catch (Exception e) {
      System.err.println("Failure in getting URL for settings page.");
      e.printStackTrace();
    }
  }

  /**
   * Main work function. See the class comment for details.
   */
  private void run() throws Exception {

    // Get OAuth access token to make further API calls.
    String accessToken = RestApiOAuthTokens.getOauthAccessToken(authRequestJSONFileName);

    // Creating the request body
    JSONObject requestBody = FileUtils.getRequestJson(viewUrlRequestJSONFileName);

    // Make API call to get URL for settings page.
    JSONObject viewUrlForManagePageResponse = RestApiViews.getUrlForSettingsView(accessToken, requestBody);

    // Display URL for settings page.
    System.out.println(viewUrlForManagePageResponse.get(RestApiUtils.VIEW_URL));
  }
}