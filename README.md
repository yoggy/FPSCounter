FPSCounter
====
simple performance check class for fps (frame per second).


How to use
----
sample code

    #include "FPSCounter.h"
    
    void target_function()
    {
        //
        // somthing to do...
        //
    }
    
    main()
    {
        FPSCounter fps;
        fps.debug_output(true);
        
        while(true) {
            target_function();
    	    
    	    // check fps
            fps.check();
        }
    }

results...

    FPSCounter : t=0.03375, fps=29.63
    FPSCounter : t=0.03391, fps=29.49
    FPSCounter : t=0.03365, fps=29.72
        .
        .
        .
       