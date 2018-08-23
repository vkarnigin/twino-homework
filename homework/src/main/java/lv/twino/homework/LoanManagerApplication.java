package lv.twino.homework;

import lv.twino.homework.config.LocalDatabaseConfiguration;
import lv.twino.homework.controller.LoanListController;
import lv.twino.homework.controller.LoanRequisitionController;

import static spark.Spark.get;
import static spark.Spark.post;

public class LoanManagerApplication {

    public static void main(String[] args) {

        LocalDatabaseConfiguration.setup();

        LoanListController loanListController = LoanListController.getInstance();
        LoanRequisitionController loanRequisitionController = LoanRequisitionController.getInstance();

        post("/apply", (req, res) -> loanRequisitionController.requestLoan(req.body(), req.ip(), res));
        get("/list", (req, res) -> loanListController.listApprovedLoans());

    }
}
