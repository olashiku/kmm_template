//
//  LoginScreen.swift
//  iosApp
//
//  Created by oluwayemisi oguntayo on 16/05/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct LoginScreen: View {
    
    private var repository :AuthRepositoryImplementation
    @StateObject  var viewModel = AuthenticationViewModel(authenticationRepository: AuthRepositoryImplementation())
    
   
    init(repository:AuthRepositoryImplementation){
        self.repository = repository
    }
    
    var body: some View {
        Text(viewModel.loginUser())
    }
}

struct LoginScreen_Previews: PreviewProvider {
    static var previews: some View {
        EmptyView()

    }
}
