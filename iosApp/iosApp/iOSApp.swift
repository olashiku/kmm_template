import SwiftUI
import shared

@main
struct iOSApp: App {
    
    init() {
        DependencyHelperKt.doInitKoin()
       }
    
   
	var body: some Scene {
		WindowGroup {
			ContentView()

            LoginScreen(repository: AuthRepositoryImplementation())
		}
	}
    
     
}
