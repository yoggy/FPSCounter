//
// main-FPSCounter-sample.cpp : Comparison of Sleep() and timeSetEvent() for accuracy
//
// github:
//     https://github.com/yoggy/FPSCounter
//
// license:
//     Copyright (c) 2015 yoggy <yoggy0@gmail.com>
//     Released under the MIT license
//     http://opensource.org/licenses/mit-license.php
//
#define WIN32_LEAN_AND_MEAN
#include <Windows.h>
#include <mmsystem.h>
#pragma comment(lib, "winmm.lib")

#include "FPSCounter.h"

FPSCounter fps_mm("fps_mm", 300, true);

void CALLBACK TimeCallback(UINT wTimerID, UINT msg, DWORD dwUser, DWORD dw1, DWORD dw2)
{
	fps_mm.check();
}

int main(int argc, char* argv[])
{
	// multi media timer (winmm.lib)
	MMRESULT timer_id = ::timeSetEvent(33, 0, TimeCallback, NULL, TIME_PERIODIC);

	FPSCounter fps_sleep("fps_sleep", 300, true);
	while (true) {
		Sleep(33);
		fps_sleep.check();
	}

	return 0;
}
