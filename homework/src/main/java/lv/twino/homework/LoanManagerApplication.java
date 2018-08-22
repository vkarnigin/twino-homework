package lv.twino.homework;

import lv.twino.homework.config.LocalDatabaseConfiguration;
import lv.twino.homework.controller.BlacklistController;
import lv.twino.homework.controller.GeolocationController;
import lv.twino.homework.controller.LoanListController;
import lv.twino.homework.controller.LoanRequisitionController;

import static spark.Spark.get;
import static spark.Spark.post;

public class LoanManagerApplication {

    public static void main(String[] args) {
        LocalDatabaseConfiguration.setup();
        GeolocationController.init();
        BlacklistController.loadCache();

        post("/apply", (req, res) -> LoanRequisitionController.requestLoan(req, res));
        get("/list", (req, res) -> LoanListController.listApprovedLoans());
    }

}
