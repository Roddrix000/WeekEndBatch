package Logics;
import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;

public class JsonUpdater {

    public static void main(String[] args) throws IOException {
        String jsonString = "[{\"type\":\"login\",\"reference\":\"OPLF202400001905\",\"status\":\"IN_PROGRESS\",\"initialStatus\":null,\"children\":[{\"type\":\"NAME_MATCH\",\"reference\":\"OPLF202400001905\",\"status\":\"COMPLETED\",\"initialStatus\":null,\"children\":[]},{\"type\":\"BUREAU_DETAILS\",\"reference\":\"OPLF202400001905\",\"status\":\"COMPLETED\",\"initialStatus\":null,\"children\":[]},{\"type\":\"EXTERNAL_BRE\",\"reference\":\"OPLF202400001905\",\"status\":\"COMPLETED\",\"initialStatus\":null,\"children\":[]},{\"type\":\"LEAD_INTEGRATION\",\"reference\":\"OPLF202400001905\",\"status\":\"COMPLETED\",\"initialStatus\":null,\"children\":[]},{\"type\":\"MOBILE_NO_VERIFY\",\"reference\":\"OPLF202400001905\",\"status\":\"COMPLETED\",\"initialStatus\":null,\"children\":[]},{\"type\":\"AML_INTEGRATION\",\"reference\":\"OPLF202400001905\",\"status\":\"COMPLETED\",\"initialStatus\":null,\"children\":[]},{\"type\":\"IRL_INTEGRATION\",\"reference\":\"OPLF202400001905\",\"status\":\"COMPLETED\",\"initialStatus\":null,\"children\":[]},{\"type\":\"PAN_AADHAAR_LINKAGE\",\"reference\":\"OPLF202400001905\",\"status\":\"COMPLETED\",\"initialStatus\":null,\"children\":[]},{\"type\":\"LOAN_DETAILS\",\"reference\":\"OPLF202400001905\",\"status\":\"COMPLETED\",\"initialStatus\":null,\"children\":[]},{\"type\":\"FACE_MATCH\",\"reference\":\"OPLF202400001905\",\"status\":\"COMPLETED\",\"initialStatus\":null,\"children\":[]},{\"type\":\"POSIDEX_INTEGRATION\",\"reference\":\"OPLF202400001905\",\"status\":\"COMPLETED\",\"initialStatus\":null,\"children\":[]},{\"type\":\"BNPL_1_AVAILABLE\",\"reference\":\"OPLF202400001905\",\"status\":\"SKIPPED\",\"initialStatus\":null,\"children\":[]},{\"type\":\"GO_NOGO\",\"reference\":\"OPLF202400001905\",\"status\":\"COMPLETED\",\"initialStatus\":null,\"children\":[]},{\"type\":\"BNPL_1\",\"reference\":\"OPLF202400001905\",\"status\":\"COMPLETED\",\"initialStatus\":null,\"children\":[]},{\"type\":\"ADDRESS\",\"reference\":\"OPLF202400001905\",\"status\":\"COMPLETED\",\"initialStatus\":null,\"children\":[]},{\"type\":\"REVERT_ENHANCEMENT\",\"reference\":\"OPLF202400001905\",\"status\":\"COMPLETED\",\"initialStatus\":null,\"children\":[]},{\"type\":\"KYC_DETAILS\",\"reference\":\"OPLF202400001905\",\"status\":\"COMPLETED\",\"initialStatus\":null,\"children\":[]},{\"type\":\"ADDRESS_MATCH\",\"reference\":\"OPLF202400001905\",\"status\":\"COMPLETED\",\"initialStatus\":null,\"children\":[]},{\"type\":\"BASIC_DETAILS\",\"reference\":\"OPLF202400001905\",\"status\":\"COMPLETED\",\"initialStatus\":null,\"children\":[]},{\"type\":\"PROFILE_INCOME_DETAILS\",\"reference\":\"OPLF202400001905\",\"status\":\"COMPLETED\",\"initialStatus\":null,\"children\":[]}]}]";
        System.out.println(jsonString);
        System.out.println("*************************************************************");
        // Convert JSON string to JsonNode
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonString);

        // Update status for specific key (e.g., LOAN_DETAILS)
        String keyToUpdate = "EXTERNAL_BRE";
        String newStatus = "Completed";

        updateStatus(rootNode, keyToUpdate, newStatus);

        // Convert updated JsonNode back to JSON string
        String updatedJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        System.out.println("Updated JSON:\n" + updatedJson);
    }

    // Recursive function to find and update the status of the given key
    public static void updateStatus(JsonNode node, String keyToUpdate, String newStatus) {
        if (node.isObject()) {
            ObjectNode objectNode = (ObjectNode) node;

            // If the node contains "type" and it matches the key, update its status
            if (objectNode.has("type") && objectNode.get("type").asText().equals(keyToUpdate)) {
                objectNode.put("status", newStatus);
            }

            // If the node has "children", iterate over them
            if (objectNode.has("children")) {
                JsonNode childrenNode = objectNode.get("children");
                for (JsonNode child : childrenNode) {
                    updateStatus(child, keyToUpdate, newStatus); // Recursive call
                }
            }
        }
    }
}
