//
//  AuthenticationViewModel.swift
//  iosApp
//
//  Created by oluwayemisi oguntayo on 15/05/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
import os.log



@MainActor class AuthenticationViewModel:ObservableObject {
    
    private var authenticationRepository:AuthenticationRepository? = nil

    
    init(authenticationRepository: AuthenticationRepository? = nil) {
        self.authenticationRepository = authenticationRepository
    }
    
//    func makecall(){
//        var loginRequest = LoginRequest(devicename: "String", deviceplatform: "String", deviceversion: "String", mobiledeviceid: "String", mobilepushuserid: "String", password: "String", source: "String", username: "String")
//
//
//        makeLoginCall(request: loginRequest) { request, completion in
//            self.authenticationRepository?.login(loginRequest: request as LoginRequest) {
//            response: LoginResponse?, error: Error? in
//                completion(response, error)
//            }
//        }
//
//    }

 
    
    
    

    
    func makeLoginCallLegit() -> String{
        
               var request = LoginRequest(devicename: "String", deviceplatform: "String", deviceversion: "String", mobiledeviceid: "String", mobilepushuserid: "String", password: "String", source: "String", username: "String")
        
        self.authenticationRepository?.login(loginRequest: request) { result, error in
            switch result {
            case let success as NetworkResultSuccess<LoginResponse>:
                let loginResponse : LoginResponse = success.data
                print("myloginResponse \(loginResponse) ")
                break
            case let failed as NetworkResultFailed<LoginResponse>:
                let error : LoginResponse = failed.message
                MyLogger().custom("myloginResponse \(String(describing: error.response?.message)) ")
                break
            case let error as  NetworkResultErrror:
                let exceptionMessage = error.exception.message
            break
            default:
                print("no x value")
            }
            
            if((error) != nil){
                
            }
        }
         return ""
    }
    
//    func makeLoginCall<R, T>(request: R, response: T, operation: @escaping (R, @escaping (T?, Error?) -> Void) -> Void) {
//
//        operation(request) { response, error in
//            switch response {
//            case let success as NetworkResultSuccess<T >:
//                let loginResponse: T = success.data
//                print("myloginResponse \(loginResponse)")
//                break
//            case let failed as NetworkResultFailed<T>:
//                let error: T = failed.message
//                print("myloginResponse \(error.responsemessage)")
//                break
//            case let error as NetworkResultError:
//                let exceptionMessage = error.exception.message
//                break
//            default:
//                print("no x value")
//            }
//
//            if error != nil {
//                // Handle error
//            }
//        }
//    }
}
