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
    @State var toolbarButtonActive = false
    
    var body: some View {
        NavigationStack {
            articlesScreenView
            .onAppear() {
                viewModel.getState()
            }
            .popover(isPresented: $toolbarButtonActive, content: {
                AboutScreenView()
            })
            .toolbar {
                Button(action: {
                    print("ButtonPressed")
                    toolbarButtonActive = true
                }, label: {
                    Image(systemName: "plus")
                        .resizable()
                })
            }
        }
    }
    
    var articlesScreenView: some View {
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
    }
}

struct ArticlesListView: View {
    let articles: [Article]
    
    var body: some View {
        ScrollView {
            LazyVStack {
                ForEach(articles, id: \.self) { article in
                    VStack(alignment: .leading) {
                        AsyncImage(url: URL(string: article.imageURL)) { phase in
                            switch phase {
                            case .empty:
                                ProgressView()
                            case .success(let image):
                                image
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                            case .failure(_):
//                                Text(err.localizedDescription)
//                                    .padding()
                                Image(systemName: "photo")
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                            @unknown default:
                                // Future-proof fallback
                                Image(systemName: "photo")
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                            }
                        }
                        .padding(.horizontal)
                        Text(article.title)
//                            .padding(.top)
                            .padding(.horizontal)
                            .font(.headline)
                        Text(article.description_)
//                            .padding(.top)
                            .padding(.horizontal)
                            .font(.subheadline)
                        Text(article.date)
                            .padding(.horizontal)
                            .frame(maxWidth: .infinity, alignment: .trailing)
                    }
                    .padding(.bottom, 16)
                    .border(Color.green)
                    
                }
            }
        }
    }
}
