//
//  ArticlesScreenVMWrapper.swift
//  iosApp
//
//  Created by Bogdan Pankevych on 13.05.2026.
//

import Foundation
import Shared

@MainActor
class ArticlesScreenVMWrapper: ObservableObject {
    let kmmViewModel =  ArticlesViewModel()
    
    @Published var state: ArticlesState = ArticlesState(articles: [], error: nil, loading: true)
    
    func getState()  {
        Task {
            for await state in kmmViewModel.articlesStateFlow {
                self.state = state
            }
            
        }
       
//        throw NSError(domain: "", code: 0, userInfo: nil)
    }
}
