package dao.team.schedule;

public class ScheduleDaoImpl {

	 public static String coordToAddr(double x, double y){
	        String url = "https://dapi.kakao.com/v2/local/geo/coord2address.json?x="+x+"&y="+y+"&input_coord=WGS84";
	        String addr = "";
	        try{
	            addr = getRegionAddress(getJSONData(url));
	            logger.info(addr);
	        }catch(Exception e){
	            logger.error("주소 api 요청 에러", e);
	            e.printStackTrace();
	        }
	        return addr;
	    }
	 
	 private static String getJSONData(String apiUrl) throws Exception {
	        String jsonString = new String();
	        String buf;
	        URL url = new URL(apiUrl);
	        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
	        String auth = "KakaoAK "+apikey;
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("X-Requested-With", "curl");
	        conn.setRequestProperty("Authorization", auth);
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(
	                conn.getInputStream(), "UTF-8"));
	        while ((buf = br.readLine()) != null) {
	            jsonString += buf;
	        }
	        return jsonString;
	    }
	 
	 private static String getRegionAddress(String jsonString) {
	        String value = "";
	        JSONObject jObj = (JSONObject) JSONValue.parse(jsonString);
	        JSONObject meta = (JSONObject) jObj.get("meta");
	        long size = (long) meta.get("total_count");
	        if(size>0){
	            JSONArray jArray = (JSONArray) jObj.get("documents");
	            JSONObject subJobj = (JSONObject) jArray.get(0);
	            JSONObject roadAddress =  (JSONObject) subJobj.get("road_address");
	            if(roadAddress == null){
	                JSONObject subsubJobj = (JSONObject) subJobj.get("address");
	                value = (String) subsubJobj.get("address_name");
	            }else{
	                value = (String) roadAddress.get("address_name");
	            }
	            if(value.equals("") || value==null){
	                subJobj = (JSONObject) jArray.get(1);
	                subJobj = (JSONObject) subJobj.get("address");
	                value =(String) subJobj.get("address_name");    
	            }
	        }
	        return value;
	    }


}
