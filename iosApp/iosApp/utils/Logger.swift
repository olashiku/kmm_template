//
//  Logger.swift
//  iosApp
//
//  Created by oluwayemisi oguntayo on 28/05/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import os.log


@available(iOS 14.0, *)
struct MyLogger {
    let logger = Logger(subsystem: "com.github.furkankaplan", category: "bispy")

    func custom(_ message: String) {
        logger.error("\(message)")
        logger.log("\(message)")
        logger.fault("\(message)")
        logger.info("\(message)")
    }
}
