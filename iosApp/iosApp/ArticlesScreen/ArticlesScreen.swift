//
//  ArticlesScreen.swift
//  iosApp
//
//  Created by Bogdan Pankevych on 13.05.2026.
//

import SwiftUI
import Shared

struct ArticlesScreen: View {
    @StateObject var viewModel = ArticlesScreenVMWrapper()
//    @State var state = ArticlesState(articles: [], error: nil, loading: true)
    
    var body: some View {
        VStack {
            if viewModel.state.loading {
                ProgressView()
            }
            if viewModel.state.error != nil {
                Text("Error: \(viewModel.state.error!)")
            }
            if !viewModel.state.articles.isEmpty {
                ArticlesListView(articles: viewModel.state.articles)
            }
        }
        .onAppear() {
            viewModel.getState()
        }
//        .task {
//            do {
//                state = try await viewModel.getState()
//            } catch {
//                
//            }
//        }
    }
}

struct ArticlesListView: View {
    let articles: [Article]
    
    var body: some View {
        LazyVStack {
            ForEach(articles, id: \.self) { article in
                VStack() {
                    Text(article.imageURL)
                        .padding()
                    Text(article.title)
                        .padding()
                    Text(article.description_)
                        .padding()
                    Text(article.date)
                        .padding()
                }
                .padding(.bottom, 16)
                .border(Color.green)
                
            }
        }
    }
}
