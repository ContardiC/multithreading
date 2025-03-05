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

## Daemon Threads
Background threads that do not prevent the application from exiting if the main thread terminates

## Daemon Thread - Scenario 1
- Background tasks, that should not block our application from terminating <br/>
**Example:** File saving thread in a TextEditor
## Daemon Thread - Scenario 2
- Code in a worker thread is not under out control, and we do not want it to block our application from terminating.
**Example:** Worker thread that use an external library