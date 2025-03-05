# Thread Termination - Why and When?

- Threads consume resources
  - Memory and kernel resources
  - CPU cycles and cache memory
- If a thread its work, but the application is still running, we want to clean up the thread's resources
- If a thread is misbehaving, we want to stop it
- By default, the application will not stop as long as at least one thread is still running

## In this package
- Thread termination
- Thread.interrupt()
- Daemon threads