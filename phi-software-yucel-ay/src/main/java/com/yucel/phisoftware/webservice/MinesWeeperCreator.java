package com.yucel.phisoftware.webservice;

import java.util.ArrayList;
import java.util.List;

public class MinesWeeperCreator {

	int column;
	int row;
	char[][] mineTable;

	public List<String> crateMinesweeper(String[] s) {

		row = s.length;
		column = s[0].length();
		mineTable = new char[row][column];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				mineTable[i][j] = s[i].charAt(j);
			}
		}

		calcAdjoint();

		List<String> newList = new ArrayList<String>();
		String mineValue = "";
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				mineValue += mineTable[i][j];
			}
			newList.add(mineValue);
			mineValue = "";
		}
		return newList;

	}

	public void calcAdjoint() {
		for (int y = 0; y < row; y++) {
			for (int x = 0; x < column; x++) {
				if (mineTable[y][x] != '*') {
					mineTable[y][x] = mineAdjoint(y, x);
				}
			}
		}
	}

	public char mineAdjoint(int y, int x) {
		int mineCount = 0;
		mineCount += calcMainAdjoint(y - 1, x - 1);
		mineCount += calcMainAdjoint(y - 1, x);
		mineCount += calcMainAdjoint(y - 1, x + 1);
		mineCount += calcMainAdjoint(y, x - 1);
		mineCount += calcMainAdjoint(y, x + 1);
		mineCount += calcMainAdjoint(y + 1, x - 1);
		mineCount += calcMainAdjoint(y + 1, x);
		mineCount += calcMainAdjoint(y + 1, x + 1);
		if (mineCount > 0) {
			return (char) (mineCount + 48);
		} else {
			return '0';
		}
	}

	public int calcMainAdjoint(int y, int x) {
		if (y >= 0 && y < row && x >= 0 && x < column && mineTable[y][x] == '*') {
			return 1;
		} else {
			return 0;
		}
	}

}
