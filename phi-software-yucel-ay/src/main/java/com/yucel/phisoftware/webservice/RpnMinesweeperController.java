package com.yucel.phisoftware.webservice;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yucel.phisoftware.model.MinesWeeper;
import com.yucel.phisoftware.model.MinesWeeperResult;
import com.yucel.phisoftware.model.Rpn;
import com.yucel.phisoftware.model.RpnResult;

@RestController
public class RpnMinesweeperController {

	@RequestMapping(value = "/rpn", method = RequestMethod.POST)
	public ResponseEntity<RpnResult> rpnCalculate(@RequestBody Rpn rpn) {

		RpnCalculate rpnCalculate = new RpnCalculate();
		int result = rpnCalculate.rpnCalculater(rpn.getExpression());

		RpnResult rpnResult = new RpnResult();
		rpnResult.setResult(result);

		return new ResponseEntity<RpnResult>(rpnResult, HttpStatus.OK);
	}

	@RequestMapping(value = "/minesweeper", method = RequestMethod.POST)
	public ResponseEntity<MinesWeeperResult> minesWeeper(@RequestBody MinesWeeper minesWeeper) {

		MinesWeeperCreator minesWeeperCreator = new MinesWeeperCreator();
		String[] s = new String[minesWeeper.getSquare().size()];
		s = minesWeeper.getSquare().toArray(s);

		List<String> result = minesWeeperCreator.crateMinesweeper(s);
		MinesWeeperResult minesWeeperResult = new MinesWeeperResult();
		minesWeeperResult.setHints(result);

		return new ResponseEntity<MinesWeeperResult>(minesWeeperResult, HttpStatus.OK);

	}

}
