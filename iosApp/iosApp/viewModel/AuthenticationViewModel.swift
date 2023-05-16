//
//  AuthenticationViewModel.swift
//  iosApp
//
//  Created by oluwayemisi oguntayo on 15/05/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

@MainActor class AuthenticationViewModel:ObservableObject {
    
    private var authenticationRepository:AuthenticationRepository? = nil

    
    init(authenticationRepository: AuthenticationRepository? = nil) {
        self.authenticationRepository = authenticationRepository
    }
    
    
    func loginUser() -> String{
        
        let request = LoginRequest(devicename: "Android SDK built for x86", deviceplatform: "Android", deviceversion: "1.0", mobiledeviceid: "8755326412e91de0", mobilepushuserid: "69474fb5-dd3e-48e7-82a3-1a570a9bb3ac", password: "12345678", source: "Android", username: "2347066353204")
        
     
            self.authenticationRepository?.login(loginRequest: request) { result, error in
                
                if let result = result{
                DispatchQueue.main.async{
                   
                }
                }
                
                else if let error = error{
                DispatchQueue.main.async{
                   

                }
                }
                
//                print("result \(result! as NetworkResult<LoginResponse>)")
//                print("error \(error)")
//
//                if let loginResponse = result as? NetworkResult<LoginResponse> {
//                    // Access the value of result here
//                    print("here is my value")
//                    print(loginResponse)
//
//                } else if let error = error {
//                    // Handle the error here
//                }
            }
            
        
        return "hello world"
    }
}
